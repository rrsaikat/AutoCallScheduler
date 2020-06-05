/*
 *       Copyright (c) 2020. RRsaikat
 *
 *       Licensed under the Apache License, Version 2.0 (the "License");
 *       you may not use this file except in compliance with the License.
 *       You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *       Unless required by applicable law or agreed to in writing,
 *       software distributed under the License is distributed on an "AS IS" BASIS,
 *       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *       See the License for the specific language governing permissions and
 *       limitations under the License.
 */

package com.rezwan.autocallscheduler.ui

import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.rezwan.autocallscheduler.R
import com.rezwan.autocallscheduler.model.SchedulerModel
import com.rezwan.autocallscheduler.utils.TimeUtils
import kotlinx.android.synthetic.main.activity_schedule.*
import java.util.*

class ScheduleActivity : BaseActivity(), DatePicker.OnDateChangedListener,
    TimePicker.OnTimeChangedListener {
    private val schedulerModel = SchedulerModel(0, 0, 0, 0, 0, "")
    private var mhour = 0
    private var mmin = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setupToolbar()
        initPickers()
        initListener()
    }

    private fun setupToolbar() {
        supportActionBar?.apply {
            title = ""
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun initPickers() {
        with(Calendar.getInstance()) {
            mhour = this.get(Calendar.HOUR_OF_DAY)
            mmin = this.get(Calendar.MINUTE)

            val yy: Int = this.get(Calendar.YEAR)
            val mm: Int = this.get(Calendar.MONTH)
            val dd: Int = this.get(Calendar.DAY_OF_MONTH)

            schedulerModel.day = dd
            schedulerModel.month = mm + 1
            schedulerModel.year = yy
            schedulerModel.hour = mhour
            schedulerModel.min = mmin
            schedulerModel.format = TimeUtils.getAmPmFormat(mhour)

            dateTimePicker.init(yy, mm, dd, this@ScheduleActivity)
            timepicker.setOnTimeChangedListener(this@ScheduleActivity)
        }
    }

    private fun initListener() {
        btnAutoCaller.setOnClickListener {
            viewModel.setLiveScheduler(schedulerModel)
            super.onBackPressed()
        }
    }

    override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        schedulerModel.year = year
        schedulerModel.month = monthOfYear + 1
        schedulerModel.day = dayOfMonth
    }

    override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
        schedulerModel.hour = hourOfDay
        schedulerModel.min = minute
        schedulerModel.format = TimeUtils.getAmPmFormat(hourOfDay)
    }
}
