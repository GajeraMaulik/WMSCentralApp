package com.example.wmscentralapp.PoRecevingScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.PickedItemAdapter
import com.example.wmscentralapp.Adapter.PoRecevingListAdapter
import com.example.wmscentralapp.Model.PickedItemData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_picked_item.*
import kotlinx.android.synthetic.main.activity_po_receving_list.*

class PoRecevingListActivity : AppCompatActivity() {

    var poRecevingList: ArrayList<PickedItemData> = ArrayList()
    lateinit var adapter: PoRecevingListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_po_receving_list)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Po_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        adapter = PoRecevingListAdapter(this,poRecevingList)
        rvPoRecevingList.adapter =adapter
        prepareItemData()


    }

    private fun prepareItemData() {
        var pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579501","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579510","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579520","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        pickedData = PickedItemData("00579500","07/20/2021","15:51")
        poRecevingList.add(pickedData)

        adapter.notifyDataSetChanged()

    }
}