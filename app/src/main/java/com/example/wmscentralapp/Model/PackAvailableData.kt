package com.example.wmscentralapp.Model

class PackAvailableData {

    lateinit var itemno :String
    lateinit var lineno :String
    lateinit var qty:String
    lateinit var qtyPiked:String
    lateinit var carton:String

    constructor()

    constructor(itemno:String,lineno:String,qty:String,qtyPiked:String,carton:String){
        this.itemno = itemno
        this.lineno =  lineno
        this.qty = qty
        this.qtyPiked = qtyPiked
        this.carton = carton

    }
}