package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(),OnFragmentClickListener {
    private val preferences get() = Injector.preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (preferences.getString(KEY_TEXT) == ""){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment1())
                .addToBackStack(null)
                .commit()
        } else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment2())
                .addToBackStack(null)
                .commit()
        }

    }
    override fun onClick(enteredText: String) {
        val fragment3 = Fragment3()
        val bundle = Bundle()
        bundle.putString(KEY_TEXT, enteredText)
        fragment3.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment3)
            .addToBackStack(null)
            .commit()
    }
    companion object {
        const val KEY_TEXT = "keyText"
        const val KEY_TEXT_2 = "keyText2"
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}