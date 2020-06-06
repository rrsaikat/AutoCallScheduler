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

import android.content.Intent
import android.os.Bundle
import com.rezwan.autocallscheduler.R
import com.rezwan.autocallscheduler.utils.BrowserUtils
import kotlinx.android.synthetic.main.activity_dev_info.*

class DevInfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_info)
        initToolbar()
        initListener()
        tvDevLink.setHtml("<a href=\"https://github.com/rrsaikat\">https://github.com/rrsaikat</a>")
    }

    private fun initListener() {
        btnDev.setOnClickListener {
            BrowserUtils.openBrowser(this, "https://github.com/rrsaikat")
        }

        btnProject.setOnClickListener {
            BrowserUtils.openBrowser(this, "https://github.com/rrsaikat/AutoCallScheduler")
        }
    }

    private fun initToolbar(){
        supportActionBar?.apply {
            title = "Details"
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }
    }
}
