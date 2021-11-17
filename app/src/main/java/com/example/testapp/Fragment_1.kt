package com.example.testapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testapp.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1) {
    private var _binding: Fragment1Binding? = null

    private val  binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)

        binding.apply {
            fragText.text = "newldkfl"
                btnToast.setOnClickListener { // фигурные - лямбда вызов - передаем  // круглые - передаем параметры
                    Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
                }
        }
        /*click(5)*/
        click {
            Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null // зануляем чтобы не было утечки памяти
            // в MainActivity - не прописываем - он сам зануляет
    }

    /*fun click(a: Int){

    }*/

    private fun click (clickable: () -> Unit){
        clickable.invoke()
    }
    // java style
    fun click(clickable: Clickable){
        clickable.clicked()
    }

    interface Clickable{
        fun clicked()
    }
}