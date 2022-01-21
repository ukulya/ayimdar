package com.example.testapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.database.Employee
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnFragmentClickListener {

    private val dbInstance get() = Injector.database

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
        //val bundle = Bundle()
        //bundle.putString(dbInstance.i, enteredID)
        //fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}