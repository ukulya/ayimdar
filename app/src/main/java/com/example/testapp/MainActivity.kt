package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),OnFragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FormFragment())
            .addToBackStack(null)
            .commit()
    }
    override fun onClick() {
        val fragment2 = ResultFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
    override fun onClickEdit() {
        val fragmentEdit = EditFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentEdit)
            .addToBackStack(null)
            .commit()
    }
    override fun onClickDelete() {
        val fragmentDelete = DeleteFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentDelete)
            .addToBackStack(null)
            .commit()
    }
}