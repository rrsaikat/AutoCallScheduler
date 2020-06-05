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

package com.rezwan.autocallscheduler.viewmodel

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rezwan.autocallscheduler.model.SchedulerModel

class AppViewModel(app: Application) : BaseViewModel(app) {
    internal val currentSchedulerObservable = MutableLiveData<SchedulerModel>()
    internal val permissionObservable = MutableLiveData<AppPermissions>()

    fun observeScheduler(
        owner: LifecycleOwner,
        observer: Observer<SchedulerModel>
    ) = currentSchedulerObservable.observe(owner, observer)

    fun setLiveScheduler(scheduler: SchedulerModel) {
        currentSchedulerObservable.value = scheduler
    }

    sealed class AppPermissions {
        class NO_PERMISSION_REQUIRED : AppPermissions()
        class GRANTED : AppPermissions()
        class NOT_GRANTED : AppPermissions()
        class SHOW_RATIONALE : AppPermissions()
    }
}