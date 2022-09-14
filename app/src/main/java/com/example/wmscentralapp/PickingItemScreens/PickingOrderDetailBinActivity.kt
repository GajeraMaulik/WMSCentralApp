package com.example.wmscentralapp.PickingItemScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.ItemsDetailsAdapter
import com.example.wmscentralapp.Adapter.ItemsDetailsBinAdapter
import com.example.wmscentralapp.Model.PickOrderBinData
import com.example.wmscentralapp.Model.PickOrderData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_picking_order_detail.*
import kotlinx.android.synthetic.main.activity_picking_order_detail_bin.*

class PickingOrderDetailBinActivity : AppCompatActivity() {

    lateinit var itemsDetailsAdapter: ItemsDetailsBinAdapter
    var orderList: ArrayList<PickOrderBinData> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_order_detail_bin)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_Odb.setOnClickListener {
            finish()
        }

        itemsDetailsAdapter = ItemsDetailsBinAdapter(this,orderList)
        rvItemsBin.adapter = itemsDetailsAdapter
        preData()

    }

    private fun preData() {
        val bindata = PickOrderBinData("s","D-3-08-1",116.000)
        orderList.add(bindata)

        PickOrderBinData("s","D-3-03-2",110.000)
        orderList.add(bindata)

        itemsDetailsAdapter.notifyDataSetChanged()
    }
}