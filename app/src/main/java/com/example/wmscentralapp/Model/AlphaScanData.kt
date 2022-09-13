package com.example.wmscentralapp.Model

class AlphaScanData {

     lateinit var itemno :String
    lateinit var itemname :String
    var viewtype : Int = 0
    constructor()

    constructor(itemno:String,itemname:String){
        this.itemno = itemno
        this.itemname =  itemname

    }

    @JvmName("setItemname1")
    fun setItemname(itemname:String){
        this.itemname = itemname
    }
    @JvmName("getItemname1")
    fun getItemname():String{
        return itemname
    }

    @JvmName("setItemno1")
    fun setItemno(itemno: Char){
        this.itemno = itemno.toString()
    }
    @JvmName("getItemno1")
    fun getItemno():String{
        return itemno
    }

    @JvmName("setType1")
    fun setType(type: Int){
        this.viewtype = type
    }

    @JvmName("getType1")
    fun getType():Int{
        return viewtype
    }
}