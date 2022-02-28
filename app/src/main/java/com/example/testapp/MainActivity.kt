package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment())
            .commit()

    }
    override fun onClick(position: Long) {
        val details = DetailsFragment()
        val bundle = Bundle()
        bundle.putLong("id", position)
        details.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, details)
            .addToBackStack(null)
            .commit()
    }
}