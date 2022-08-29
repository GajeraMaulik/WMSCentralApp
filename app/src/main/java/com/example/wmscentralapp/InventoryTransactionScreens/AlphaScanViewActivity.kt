package com.example.wmscentralapp.InventoryTransactionScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.AlphaScanAdapter
import com.example.wmscentralapp.Adapter.PIAAdapter
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.Model.PIAData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_alpha_scan_view.*
import kotlinx.android.synthetic.main.activity_picking_item_available.*

class AlphaScanViewActivity : AppCompatActivity() {

    var itemList: ArrayList<AlphaScanData> = ArrayList()
    lateinit var adapter: AlphaScanAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alpha_scan_view)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_AlphaScan_Btn.setOnClickListener {

                onBackPressed()
                return@setOnClickListener


        }
   /*     list_AlphaScanLabel.setOnClickListener {
            searchBar_Close.visibility = View.VISIBLE
            characterLabal.visibility = View.VISIBLE
            rvAlphaListItem.visibility = View.VISIBLE
            list_AlphaScanLabel.visibility = View.GONE
        }*/

        adapter = AlphaScanAdapter(this,itemList)
        rvAlphaListItem.adapter = adapter
        prepareItemData()

    }
    private fun prepareItemData() {
        var piaData = AlphaScanData("J5080","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5081","H RUSTIC DOTS")
        itemList.add(piaData)


        piaData = AlphaScanData("J5082","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5084","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5085","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5087","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5089","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5083","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("J5084","H RUSTIC DOTS")
        itemList.add(piaData)


        adapter.notifyDataSetChanged()

    }
}