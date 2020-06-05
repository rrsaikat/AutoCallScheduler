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

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object TimeUtils {
    fun stringForRemainingTime(milliseconds: Long): String {
        val day = TimeUnit.MILLISECONDS.toDays(milliseconds)
        val hour = (TimeUnit.MILLISECONDS.toHours(milliseconds) - TimeUnit.DAYS.toHours(
            TimeUnit.MILLISECONDS.toDays(milliseconds)
        )).toString()
        val minute = ((TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(
            TimeUnit.MILLISECONDS.toHours(
                milliseconds
            )
        )).toString())
        val seconds = (TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(
            TimeUnit.MILLISECONDS.toMinutes(
                milliseconds
            )
        ))

        return if (day == 0L) "${hour}:${minute}:${seconds}" else "${day}Day ${hour}:${minute}:${seconds}"

    }

    fun stringForElapsedTime(milliseconds: Long): String {
        var milliseconds = milliseconds
        if (milliseconds < 0 || milliseconds >= 24 * 60 * 60 * 1000) {
            return "00:00"
        }
        milliseconds /= 1000
        var minute = (milliseconds / 60).toInt()
        val hour = minute / 60
        val second = (milliseconds % 60).toInt()
        minute %= 60
        val stringBuilder = StringBuilder()
        val mFormatter = Formatter(stringBuilder, Locale.getDefault())
        return mFormatter.format("%02d:%02d:%02d", hour, minute, second).toString()
//        return if (hour > 0) {
//            mFormatter.format("%02d:%02d:%02d", hour, minute, second).toString()
//        } else {
//            mFormatter.format("%02d:%02d", minute, second).toString()
//        }
    }

    fun formatDuration(duration: Int): String {
        val d = Date(duration * 1000L)
        val df = SimpleDateFormat("HH:mm:ss", Locale.US) // HH for 0-23
        df.timeZone = (TimeZone.getTimeZone("GMT"))
        return df.format(d)
    }

    fun getAmPmFormat(hour: Int): String {
        return if (hour == 0) {
            //mhour += 12;
            "AM"
        } else if (hour == 12) {
            "PM";
        } else if (hour > 12) {
            //mhour -= 12;
            "PM";
        } else {
            "AM";
        }
    }
}