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
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var txtInput: TextView

    private var lastNumeric: Boolean = false

    private var stateError: Boolean = false

    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtInput)

        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnZero = findViewById<Button>(R.id.btnZero)
        btnOne.setOnClickListener { onDigit(btnOne) }
        btnTwo.setOnClickListener { onDigit(btnTwo) }
        btnThree.setOnClickListener { onDigit(btnThree) }
        btnFour.setOnClickListener { onDigit(btnFour) }
        btnFive.setOnClickListener { onDigit(btnFive) }
        btnSix.setOnClickListener { onDigit(btnSix) }
        btnSeven.setOnClickListener { onDigit(btnSeven) }
        btnEight.setOnClickListener { onDigit(btnEight) }
        btnNine.setOnClickListener { onDigit(btnNine) }
        btnZero.setOnClickListener { onDigit(btnZero) }

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        btnAdd.setOnClickListener { onOperator(btnAdd) }
        btnSubtract.setOnClickListener { onOperator(btnSubtract) }
        btnMultiply.setOnClickListener { onOperator(btnMultiply) }
        btnDivide.setOnClickListener { onOperator(btnDivide) }

        val btnDecimal = findViewById<Button>(R.id.btnDecimal)
        btnDecimal.setOnClickListener { onDecimalPoint(btnDecimal) }

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener { onClear(btnClear) }

        val btnEqual = findViewById<Button>(R.id.btnEqual)
        btnEqual.setOnClickListener { onEqual(btnEqual) }
    }

    /*override fun onClick(v: View) {
        when (v.id) {
            R.id.btnOne -> {}
        }
    }*/

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