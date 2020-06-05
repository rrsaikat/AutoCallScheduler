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

import android.text.SpannableString
import android.text.SpannedString
import android.text.style.QuoteSpan
import android.text.style.RelativeSizeSpan
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans

object StringUtils {
    fun timeStringToSpan(inputStr:String): SpannedString {
        return buildSpannedString {
            append("Remaining Time ")
            inSpans(RelativeSizeSpan(2f), QuoteSpan()) {
                bold {
                    append("$inputStr")
                }
            }
            append(" to make a call")
        }
    }
}