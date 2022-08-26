package com.example.wmscentralapp.Model

import android.text.Editable

class PickReviewData  {

     var id : Int =0
    lateinit var item :String
    lateinit var bin :String
    lateinit var qty :String
    lateinit var date:String
    lateinit var time:String

    constructor()
    constructor(id:Int,item:String,bin:String,qty:String,date:String,time:String){
        this.id = id
        this.item = item
        this.bin = bin
        this.qty =qty
        this.date = date
        this.time = time
    }

    fun getItemno():String{
        return item
    }
    fun setItemno(item: String){
        this.item = item
    }
    fun getBinno():String{
        return bin
    }
    fun setBinno(bin: String){
        this.bin = bin
    }




}