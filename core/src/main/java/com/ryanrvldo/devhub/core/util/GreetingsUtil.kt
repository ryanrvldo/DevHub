package com.ryanrvldo.devhub.core.util

import android.content.Context
import com.ryanrvldo.devhub.core.R
import java.util.*


object GreetingsUtil {

    fun getGreetings(context: Context): String {
        val calendar: Calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0 until 12 -> context.getString(R.string.good_morning)
            in 12 until 16 -> context.getString(R.string.good_afternoon)
            in 16 until 21 -> context.getString(R.string.good_evening)
            in 21 until 24 -> context.getString(R.string.good_night)
            else -> "Unknown time."
        }
    }

}
