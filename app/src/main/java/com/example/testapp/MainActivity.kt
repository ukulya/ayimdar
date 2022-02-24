package com.example.testapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), OnFragmentClickListener {
    private lateinit var adapter: SimpleAdapter
    private val itemList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

    override fun onClick(enteredText: String) {

        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("key", enteredText)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }

    override fun onLongClick(removeItem: () -> Unit ) { // метод - потому что внутри класса
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Item deletion")
        builder.setMessage("Do you want to delete this item?")
        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
            removeItem.invoke() // лямбда - через invoke вызываем
        })
        builder.setNegativeButton("No", DialogInterface.OnClickListener { _, _ ->
        })
        builder.setNeutralButton("Cancel", DialogInterface.OnClickListener { _, _ ->
        })
        builder.show();

//        xxx(xx1())
//
//        xxx1( { xx2() } )
    }
}

//fun xx1():String {return "xxx"} // функция - потому что вне класса
//fun xxx(x: String): String {return x} // функция - потому что вне класса
//
//fun xxx1(run: () -> String) { // лямбда ф-я
//
//    //
//    run.invoke()
//    //
//
//}
//fun xx2() : String {return "xxx2"}