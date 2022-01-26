package com.example.testapp

import com.example.testapp.database.Contact

interface OnFragmentClickListener {

    fun onClick(id: Long)
    fun onClickOpenFormFragment()
    fun onClickOpenDetailsFragment()
    //fun onClickSetContact(id: Long)
    /*fun onClickEdit()
    fun onClickDelete()*/
}