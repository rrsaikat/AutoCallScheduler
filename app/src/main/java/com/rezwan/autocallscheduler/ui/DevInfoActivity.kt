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

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rezwan.autocallscheduler.R

class DevInfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_info)
        supportActionBar?.apply {
            title = "Details"
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }
    }
}
