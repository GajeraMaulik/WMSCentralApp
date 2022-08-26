package com.example.wmscentralapp.OrderComment

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "items", strict = false)
 class Items {
    @field:ElementList(
        required = true,
        empty = true,
        data = false,
        inline = true,
        name = "OrderCommentsDTO",
        entry = "OrderCommentsDTO"
    )
     var orderCommentsDTO: ArrayList<OrderCommentsDTO>? = null

    constructor()
    constructor(orderCommentsDTO: ArrayList<OrderCommentsDTO>?){
        this.orderCommentsDTO = orderCommentsDTO
    }

}