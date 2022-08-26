package com.example.wmscentralapp.PickOrderScreens

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "orderInfo", strict = false)
 class OrderInfo : Serializable {

    @field:Element(name = "ord_no", required = true)
    lateinit var ord_no: String

    @field:Element(name = "cus_no", required = true)
    lateinit var cus_no: String

    @field:Element(name = "oe_po_no", required = false)
    var oe_po_no: String? = null

    @field:Element(name = "item_no", required = true)
    lateinit var item_no: String


    @field:Element(name = "qty_ordered", required = true)
    lateinit var qty_ordered: String

    @field:Element(name = "line_no", required = true)
    lateinit var line_no: String


    @field:Element(name = "cus_name", required = true)
    lateinit var cus_name: String


    @field:Element(name = "upc_cd", required = true)
    lateinit var upc_cd: String


    @field:Element(name = "SCC14", required = true)
    lateinit var SCC14: String

    @field:Element(name = "CasePack", required = true)
    lateinit var CasePack: String

    constructor()
    constructor(ord_no:String,cus_no:String, oe_po_no:String?,item_no:String,qty_ordered:String,line_no:String,cus_name:String,upc_cd:String,SCC14:String,CasePack:String){
        this.ord_no = ord_no
        this.cus_no = cus_no
        this.oe_po_no = oe_po_no
        this.item_no=item_no
        this.qty_ordered = qty_ordered
        this.line_no = line_no
        this.cus_name = cus_name
        this.upc_cd =upc_cd
        this.SCC14 =SCC14
        this.CasePack = CasePack
    }

    fun getOrdno():String{
        return ord_no
    }

    fun setOrdno(ord_no:String){
        this.ord_no =ord_no
    }

    fun getCusno():String{
        return cus_no
    }

    fun setCusno(cus_no:String){
        this.cus_no =cus_no
    }

    fun getOepono():String{
        return ord_no
    }

    fun setOeponono(oe_po_no: String?){
        this.oe_po_no = oe_po_no
    }

    fun getItemno():String{
        return item_no
    }

    fun setItemno(item_no: String){
        this.item_no =item_no
    }

    fun getQtyord():String{
        return qty_ordered
    }

    fun setQtyord(qty_ordered: String){
        this.qty_ordered = qty_ordered
    }

    fun getLineno():String{
        return line_no
    }

    fun setLineno(line_no: String){
        this.line_no =line_no
    }

    fun getCusname():String{
        return cus_name
    }

    fun setCusname(cus_name: String){
        this.cus_name =cus_name
    }

    fun getUpccd():String{
        return upc_cd
    }

    fun setUpccd(upc_cd: String){
        this.upc_cd = upc_cd
    }

    fun getScc14():String{
        return SCC14
    }

    fun setScc14(SCC14: String){
        this.SCC14 = SCC14
    }

    fun getCasepack():String{
        return CasePack
    }

    fun setCasepack(CasePack: String){
        this.CasePack = CasePack
    }

}