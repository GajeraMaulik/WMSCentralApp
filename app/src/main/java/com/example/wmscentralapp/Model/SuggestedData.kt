package com.example.wmscentralapp.Model

import org.simpleframework.xml.Element

class SuggestedData {
    lateinit var item :String

    lateinit var Ordered : String

    lateinit var Picked: String

    lateinit var Remain : String

    lateinit var Binno : String

    lateinit var Qtyonhand:String
    constructor()

    constructor(item:String,Ordered:String,Picked:String,Remain:String,Binno:String,Qtyonhand:String){
        this.item =item
        this.Ordered = Ordered
        this.Picked = Picked
        this.Remain = Remain
        this.Binno = Binno
        this.Qtyonhand = Qtyonhand
    }
    fun getItemno():String{
        return item
    }
    fun setItemno(item: String){
        this.item = item
    }
    @JvmName("getBinno1")
    fun getBinno():String{
        return Binno
    }
    @JvmName("setBinno1")
    fun setBinno(binno: String){
        this.Binno = binno
    }
}