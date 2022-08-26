package com.example.wmscentralapp.Model

class PIAData {

    lateinit var binno :String

    lateinit var quantity:String
    constructor()

    constructor(binno:String,quantity:String){
        this.binno = binno
        this.quantity = quantity
    }
}