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
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.rezwan.autocallscheduler.R
import com.rezwan.autocallscheduler.viewmodel.AppViewModel

abstract class BaseActivity :AppCompatActivity(){
    internal val viewModel by lazy {
        vita.with(VitaOwner.Multiple(this)).getViewModel<AppViewModel>()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->{
                super.onBackPressed()
            }

            R.id.menu_devInfo -> {
                startActivity(Intent(this, DevInfoActivity::class.java))
            }
        }

        return false
    }
}