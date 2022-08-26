package com.example.wmscentralapp.PackOderScreens.PickingItem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.Adapter.PickedItemAdapter
import com.example.wmscentralapp.Model.PickedItemData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_picked_item.*

class PickedItemActivity : AppCompatActivity() {
     var pickedItemList: ArrayList<PickedItemData> = ArrayList()
    lateinit var adapter:PickedItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picked_item)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)



        val pickList = intent.getStringExtra("pickedList")
        toolBarHeader.text = pickList

        back_Btn.setOnClickListener{
            onBackPressed()
            d("wms app", "---------->${onBackPressed()}")


            return@setOnClickListener
        }

        adapter = PickedItemAdapter(this,pickedItemList)
        rvPickedItemList.adapter =adapter
        prepareItemData()
    }

    private fun prepareItemData() {
        var pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        pickedData = PickedItemData("00167070","07/20/2021","15:51:35")
        pickedItemList.add(pickedData)

        adapter.notifyDataSetChanged()

    }
    override fun onBackPressed() {

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}