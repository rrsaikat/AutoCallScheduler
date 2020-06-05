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

package com.rezwan.autocallscheduler.helper

import android.os.CountDownTimer
import com.rezwan.autocallscheduler.callbacks.TimerTaskListener
import com.rezwan.autocallscheduler.utils.TimeUtils

/*
*
* countdowntimer is an abstract class, so extend it and fill in methods
*
* */
class RTimer : CountDownTimer {
    private var mTimerlistener: TimerTaskListener? = null

    constructor(millisInFuture: Long, countDownInterval: Long) : super(
        millisInFuture,
        countDownInterval
    )

    override fun onFinish() {
        mTimerlistener?.onTimerFinished()
    }

    override fun onTick(millisUntilFinished: Long) {
        val hms: String = TimeUtils.stringForRemainingTime(millisUntilFinished)
        mTimerlistener?.onTimerTicked(hms)
    }

    fun setListener(timerTaskListener: TimerTaskListener) {
        this.mTimerlistener = timerTaskListener
    }
}