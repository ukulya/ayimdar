package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.database.Contact

class MainActivity : AppCompatActivity(),OnFragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ResultFragment())
            .addToBackStack(null)
            .commit()
    }
    override fun onClick(id: Long) {
        val fragment2 = DetailsFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
    override fun onClickOpenDetailsFragment() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }
    override fun onClickOpenFormFragment() {
        val fragment2 = FormFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}