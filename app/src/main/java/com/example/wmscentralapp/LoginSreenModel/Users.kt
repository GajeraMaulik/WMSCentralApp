package com.example.userlogindemo.XmlParsingWithApi

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name = "Users", strict = false)
 data class Users  @JvmOverloads constructor(

    @field:ElementList(
        required = true,
        name = "UserInfo",
        entry = "UserInfo",
        inline = true,
        empty = true)
    var userInfo: MutableList<UserInfo>? = null
){

}
