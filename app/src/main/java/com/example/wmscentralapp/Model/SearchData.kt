package com.example.wmscentralapp.Model

import android.text.Editable
import android.widget.EditText

class SearchData {

    lateinit var searchItem:String

    constructor()

    constructor(searchItem:String){
        this.searchItem = searchItem
    }
}