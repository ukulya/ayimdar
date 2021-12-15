package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),OnButtonClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_1, Fragment1())
            .add(R.id.fragment_container_2, Fragment2())
            .commit()

    }
    override fun onButtonClicked(imgUrl: Int) {
        val fr2 = supportFragmentManager.findFragmentById(R.id.fragment_container_2) as Fragment2
        fr2.setImgSrc(imgUrl)
    }

}