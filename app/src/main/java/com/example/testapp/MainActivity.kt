package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val item = findViewById<AppCompatButton>(R.id.btn_1)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(this)
        val adapter = SimpleAdapter {
            Toast.makeText(this, "ITEM -$it", Toast.LENGTH_SHORT).show()
            goTo(it)
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")
        }
        adapter.setData(list)
    }

    private fun goTo(position: Int) {
        val intent = Intent(this,MainActivity2::class.java) // явный - явно указываем; неявный - через manifest
        intent.putExtra("item", position) // ключ - значение
        startActivity(intent)
    }
}