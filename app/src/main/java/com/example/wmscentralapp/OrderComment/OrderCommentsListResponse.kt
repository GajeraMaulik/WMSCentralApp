package com.example.wmscentralapp.OrderComment

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "OrderCommentsListResponse", strict = false)
class OrderCommentsListResponse {

  /*  @field:Attribute(name = "xmlns:xsi")
     lateinit var xsi: String
    @field:Attribute(name = "xmlns:xsd")
    lateinit var xsd: String
*/
    @field:Element(name = "Code", required = true)
    lateinit var Code: String

    @field:ElementList(
        required = true,
        empty = true,
        data = false,
        inline = true,
        name = "Items",
        entry = "Items"
    )
     var items: ArrayList<Items>? =null

    constructor()
    constructor(xsi:String,xsd:String,code:String,items:  ArrayList<Items>?){
      //  this.xsi = xsi
       // this.xsd =xsd
        this.Code =code
        this.items = items
    }
}