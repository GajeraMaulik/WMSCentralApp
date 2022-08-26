package com.example.userlogindemo.XmlParsingWithApi

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "userInfo", strict = false)
 class UserInfo  {

    @field:Element(name = "cus_no", required = true)
    var cus_no : Int = 0

    @field:Element(name = "cus_name", required = true)
    lateinit var cus_name : String

    @field:Element(name = "addr_1", required = true)
    lateinit var addr_1 : String

    @field:Element(name = "SecurityLevel", required = false)
    var SecurityLevel : String?= null

    @field:Element(name = "email", required = false)
    var email : String? = null

   constructor()

   constructor(cus_no:Int,cus_name:String,addr_1:String,securityLevel:String?,email:String){
      this.cus_no = cus_no
      this.cus_name  = cus_name
      this.addr_1 = addr_1
      this.SecurityLevel =securityLevel
      this.email =email
   }
}
