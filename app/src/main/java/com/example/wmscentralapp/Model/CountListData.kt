package com.example.wmscentralapp.Model

class CountListData {

    lateinit var itemno:String
    lateinit var binno:String
    lateinit var qty:String
    lateinit var tagno:String
    lateinit var date:String
    lateinit var time:String
   var recount:Boolean = true

    constructor()
    constructor(itemno:String,binno:String,qty:String,tagno:String,date:String,time:String,recount:Boolean){
        this.itemno = itemno
        this.binno = binno
        this.qty = qty
        this.tagno = tagno
        this.date = date
        this.time = time
        this.recount = recount
    }

}