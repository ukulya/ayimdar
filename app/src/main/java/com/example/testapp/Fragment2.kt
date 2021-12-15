package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    private lateinit var listener: OnButtonClicked
    private lateinit var img: AppCompatImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        img = view.findViewById(R.id.imgview)
    }

    fun setImgSrc(imgUrl: Int) {
        img.setImageResource(imgUrl)
    }
}