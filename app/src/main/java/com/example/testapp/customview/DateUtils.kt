package com.example.testapp.customview

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String?.calendarFrom(pattern:String?,utc:Boolean = false):Calendar?{
    if (this == null || this.isEmpty() || pattern == null){
        return null
    }
    try {
        var dateTimeInMillis = SimpleDateFormat(pattern).parse(this).time
        val calendar = Calendar.getInstance()
        if (utc){
            dateTimeInMillis += calendar.timeZone.rawOffset
        }
        calendar.timeInMillis = dateTimeInMillis
        return calendar
    }catch (ignored:Exception){

    }
    return null
}