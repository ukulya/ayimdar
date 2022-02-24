package com.example.testapp.customview

import android.content.Context
import android.icu.util.Calendar
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.testapp.databinding.ViewSeasonBinding
import com.example.testapp.ext.viewBinding

class SeasonView @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet? = null

) : ConstraintLayout(context, attrs) {
    private val binding = viewBinding(ViewSeasonBinding::inflate)
    init{
        binding.apply{
            btn.setOnClickListener{
                text.text = getSeason(editDate.text.toString())
            }
        }

    }
    private fun getSeason(date:String): String{
        return date.calendarFrom("dd.MM.yyyy")?.let{
            when(it.get(Calendar.MONTH)){
                Calendar.DECEMBER,Calendar.JANUARY,Calendar.FEBRUARY -> "Зима"
                Calendar.MARCH,Calendar.APRIL,Calendar.MAY -> "Весна"
                Calendar.JUNE,Calendar.JULY,Calendar.AUGUST -> "Лето"
                Calendar.SEPTEMBER,Calendar.OCTOBER,Calendar.NOVEMBER -> "Осень"
                else -> "unknown"
            }
        }?: "unknown"


    }
}