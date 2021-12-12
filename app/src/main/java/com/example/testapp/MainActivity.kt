package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat.setBackground
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var txtInput: TextView

    private var lastNumeric: Boolean = false

    private var stateError: Boolean = false

    private var lastDot: Boolean = false

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtInput)

        binding.btnOne.setOnClickListener { onDigit(binding.btnOne) }
        binding.btnTwo.setOnClickListener { onDigit(binding.btnTwo) }
        binding.btnThree.setOnClickListener { onDigit(binding.btnThree) }
        binding.btnFour.setOnClickListener { onDigit(binding.btnFour) }
        binding.btnFive.setOnClickListener { onDigit(binding.btnFive) }
        binding.btnSix.setOnClickListener { onDigit(binding.btnSix) }
        binding.btnSeven.setOnClickListener { onDigit(binding.btnSeven) }
        binding.btnEight.setOnClickListener { onDigit(binding.btnEight) }
        binding.btnNine.setOnClickListener { onDigit(binding.btnNine) }
        binding.btnZero.setOnClickListener { onDigit(binding.btnZero) }
        binding.btnAdd.setOnClickListener { onOperator(binding.btnAdd) }
        binding.btnSubtract.setOnClickListener { onOperator(binding.btnSubtract) }
        binding.btnMultiply.setOnClickListener { onOperator(binding.btnMultiply) }
        binding.btnDivide.setOnClickListener { onOperator(binding.btnDivide) }
        binding.btnDecimal.setOnClickListener { onDecimalPoint(binding.btnDecimal) }
        binding.btnClear.setOnClickListener { onClear(binding.btnClear) }
        binding.btnEqual.setOnClickListener { onEqual(binding.btnEqual) }
    }


    fun onDigit(view: View) {
        if (stateError) {
            txtInput.text = (view as Button).text
            stateError = false
        } else {
            txtInput.append((view as Button).text)
        }
        lastNumeric = true
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !stateError && !lastDot) {
            txtInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        if (lastNumeric && !stateError) {
            txtInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    fun onClear(view: View) {
        this.txtInput.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    fun onEqual(view: View) {
        if (lastNumeric && !stateError) {
            val txt = txtInput.text.toString()
            val expression = ExpressionBuilder(txt).build()
            try {
                val result = expression.evaluate()
                txtInput.text = result.toString()
                lastDot = true
            } catch (ex: ArithmeticException) {
//                txtInput.text = ex.toString()
                txtInput.text = "На ноль делить нельзя"
                stateError = true
                lastNumeric = false
            }
        }
    }
}