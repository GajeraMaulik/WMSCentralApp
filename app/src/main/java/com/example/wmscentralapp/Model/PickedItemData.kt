package com.example.wmscentralapp.Model

class PickedItemData {

    lateinit var orderno:String
    lateinit var scandate:String
    lateinit var scantime : String

    constructor()
    constructor(orderno:String,scandate:String,scantime:String){
        this.orderno=orderno
        this.scandate = scandate
        this.scantime = scantime
    }
}