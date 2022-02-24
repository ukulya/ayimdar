//package com.example.testapp
//
//import android.content.Context
//import android.util.AttributeSet
//import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.core.view.isVisible
//import com.example.testapp.R
//import com.example.testapp.databinding.WeatherStateBinding
//import com.example.testapp.ext.obtainStyledAttributes
//import com.example.testapp.ext.viewBinding
//
//class LoanPaymentStateView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
//
//    private val binding = viewBinding(WeatherStateBinding::inflate)
//    var onClicked: (() -> Unit) = {}
//
//    init {
//        attrs.obtainStyledAttributes(context, R.styleable.WeatherStateView) {
//            val paymentDateText = it.getString(R.styleable.WeatherStateView_lpsvPaymentDateText) ?: ""
//            val paymentAmountText = it.getString(R.styleable.WeatherStateView_lpsvPaymentAmountText) ?: ""
//            val paymentButtonText = it.getString(R.styleable.WeatherStateView_lpsvPaymentButtonText) ?: ""
//            val paymentText = it.getString(R.styleable.WeatherStateView_lpsvPaymentText) ?: ""
//            val paymentStatus = it.getInt(R.styleable.WeatherStateView_lpsvPaymentStatus, STATUS_NEED_TO_PAY)
//            setPaymentDateText(paymentDateText)
//            setPaymentAmountText(paymentAmountText)
//            setPaymentButtonText(paymentButtonText)
//            setPaymentText(paymentText)
//            setPaymentStatus(paymentStatus)
//        }
//        binding.loanPaymentBtn.setOnClickListener { onClicked() }
//    }
//
//    fun setPaymentDateText(text: String) {
//        binding.loanPaymentDate.text = text
//    }
//
//    fun setPaymentAmountText(text: CharSequence) {
//        binding.loanPaymentAmount.text = text
//    }
//
//    fun setPaymentButtonText(text: String) {
//        binding.loanPaymentBtn.text = text
//    }
//
//    fun setPaymentText(text: String) {
//        binding.loanPaymentText.text = text
//    }
//
//    fun setPaymentStatus(status: Int) {
//        binding.apply {
//            when(status) {
//                STATUS_PAID -> {
//                    loanPaymentBtn.isVisible = false
//                    loanPaymentText.isVisible = true
//                    loanStatusIcon.isVisible = true
//                    loanStatusIcon.setImageResource(R.drawable.ic_schedule_success)
//                }
//                STATUS_NEED_TO_PAY, STATUS_NEED_TO_PAY_SOON -> {
//                    loanPaymentBtn.isVisible = true
//                    loanPaymentText.isVisible = false
//                    loanStatusIcon.isVisible = false
//                }
//                STATUS_EXPIRED -> {
//                    loanPaymentBtn.isVisible = true
//                    loanPaymentText.isVisible = false
//                    loanStatusIcon.isVisible = true
//                    loanStatusIcon.setImageResource(R.drawable.ic_schedule_overdue)
//                }
//            }
//        }
//    }
//
//    companion object {
//        private const val STATUS_PAID = 1
//        private const val STATUS_NEED_TO_PAY = 2
//        private const val STATUS_NEED_TO_PAY_SOON = 3
//        private const val STATUS_EXPIRED = 4
//    }
//}