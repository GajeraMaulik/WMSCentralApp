package com.example.wmscentralapp.PickOrderScreens

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "zwms", strict = false)
 class Zwms  {

    @field:ElementList(
        required = true,
        empty = true,
        data = false,
        inline = true,
        name = "OrderInfo",
        entry = "OrderInfo"
    )
    var orderInfo: ArrayList<OrderInfo>? = null

    constructor()
    constructor(orderInfo: ArrayList<OrderInfo>?){
        this.orderInfo = orderInfo
    }


    fun getOrderinfo():ArrayList<OrderInfo>{
        return orderInfo!!
    }

    fun setOrderinfo(orderInfo: ArrayList<OrderInfo>? ){
        this.orderInfo = orderInfo
    }


 }

