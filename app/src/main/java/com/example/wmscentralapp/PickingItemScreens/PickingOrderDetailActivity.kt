package com.example.wmscentralapp.PickingItemScreens

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.ItemsDetailsAdapter
import com.example.wmscentralapp.Model.PickOrderData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_picking_order_detail.*

class PickingOrderDetailActivity : AppCompatActivity() {
    lateinit var itemsDetailsAdapter: ItemsDetailsAdapter
    var orderList: ArrayList<PickOrderData> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_order_detail)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_Od.setOnClickListener {
            finish()
        }

        itemsDetailsAdapter = ItemsDetailsAdapter(this,orderList)
        rvItemdetails.adapter = itemsDetailsAdapter
        preData()
    }

    fun preData(){
        val orderdata = PickOrderData("F740",48.0000,845332053764,"China","0","**UNITED GIFT SHOP","000000093102",1,0)
        orderList.add(orderdata)

        PickOrderData("F740",48.0000,845332053764,"China","1","**UNITED GIFT SHOP","000000093102",1,0)
        orderList.add(orderdata)

        itemsDetailsAdapter.notifyDataSetChanged()

    }
}