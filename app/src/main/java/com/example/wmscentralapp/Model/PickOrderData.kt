package com.example.wmscentralapp.Model

class PickOrderData {

    lateinit var itemNo :String
     var qtyNo :Double = 0.0
     var upc :Long = 0
    lateinit var ssc14:String
    lateinit var case :String
    lateinit var cus_name :String
    lateinit var cusNo :String
    var lineNo:Int = 0
    var qtyPicked:Int = 0

    constructor()
    constructor(itemNo:String,qtyNo:Double,upc:Long,ssc14:String,case:String,cusname:String,cusNo:String,lineNo:Int,qtyPicked:Int){
        this.itemNo = itemNo
        this.qtyNo = qtyNo
        this.upc = upc
        this.ssc14 =ssc14
        this.case = case
        this.cus_name = cusname
        this.cusNo =cusNo
        this.lineNo = lineNo
        this.qtyPicked = qtyPicked
    }
}