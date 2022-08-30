package com.example.wmscentralapp.InventoryTransactionScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.ChangeLocationAdapter
import com.example.wmscentralapp.Adapter.CountListAdapter
import com.example.wmscentralapp.Model.CountListData
import com.example.wmscentralapp.Model.LocationData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_change_location.*
import kotlinx.android.synthetic.main.activity_inventory_count_list.*

class ChangeLocationActivity : AppCompatActivity() {

    lateinit var adapter: ChangeLocationAdapter
   var itemList: ArrayList<LocationData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_location)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Cl_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        list_LocationLabel.setOnClickListener {
            val i = Intent(this,InventoryTransactionActivity::class.java)
            startActivity(i)
            finish()
        }

        adapter = ChangeLocationAdapter(this,itemList)
        rvLocationItem.adapter = adapter
        prepareItemData()

    }

    private fun prepareItemData() {
        var data = LocationData("IMP :Import order")
        itemList.add(data)

        data = LocationData("P :PRINCETON")
        itemList.add(data)

        data = LocationData("S : SOMERVILLE ")
        itemList.add(data)

        data = LocationData("WTR : ON WATER")
        itemList.add(data)

        adapter.notifyDataSetChanged()
    }
}