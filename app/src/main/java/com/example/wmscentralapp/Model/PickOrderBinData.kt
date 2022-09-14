package com.example.wmscentralapp.Model

class PickOrderBinData {

    lateinit var location :String
    lateinit var binNo:String
     var qtyOnhand:Double = 0.0

    constructor()
    constructor(location:String,binNo:String,qtyOnhand:Double){
        this.location = location
        this.binNo = binNo
        this.qtyOnhand =qtyOnhand
    }


}