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

package com.rezwan.autocallscheduler.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.rezwan.autocallscheduler.constants.const.HTTP
import com.rezwan.autocallscheduler.constants.const.HTTPS

object BrowserUtils {
    fun openBrowser(context: Context, url: String) {
        var url = url
        if (!url.startsWith(HTTP) && !url.startsWith(
                HTTPS
            )
        ) {
            url = HTTP + url
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(
            Intent.createChooser(
                intent,
                "Choose browser"
            )
        )
    }
}