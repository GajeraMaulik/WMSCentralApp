package com.example.wmscentralapp.Model

class AlphaScanData {

    lateinit var itemno :String
    lateinit var itemname :String

    constructor()

    constructor(itemno:String,itemname:String){
        this.itemno = itemno
        this.itemname =  itemname

    }
}