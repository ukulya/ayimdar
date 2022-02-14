package com.example.testapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),OnFragmentClickListener {
    private val dbInstance get() = Injector.database

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
    /*override fun onClickRemove(id: Long) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure you wanna delete?")
        builder.setMessage("We have a message")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
            val e = dbInstance.contactDao().getById(id)
            dbInstance.contactDao().delete(e)

        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT).show()
        }

        builder.show()

    }*/
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