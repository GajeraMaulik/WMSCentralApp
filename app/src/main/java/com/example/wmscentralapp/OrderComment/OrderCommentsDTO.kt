package com.example.wmscentralapp.OrderComment

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "orderCommentsDTO", strict = false)
 class OrderCommentsDTO{


    @field:Element(name = "OrdNo", required = true)
    var OrdNo: String? = null


    @field:Element(name = "Comment", required = true)
    lateinit var Comment: String


    @field:Element(name = "StartOrdNo", required = false)
     var StartOrdNo: String? = null


    @field:Element(name = "EndOrdNo", required = false)
    var EndOrdNo: String? = null


    @field:Element(name = "Note", required = false)
     var Note: String? = null

    constructor()
    constructor(ordNo:String?,comment:String,startordno:String?,endordno:String?,note:String?){
        this.OrdNo = ordNo
        this.Comment = comment
        this.StartOrdNo = startordno
        this.EndOrdNo =endordno
        this.Note = note

    }
}