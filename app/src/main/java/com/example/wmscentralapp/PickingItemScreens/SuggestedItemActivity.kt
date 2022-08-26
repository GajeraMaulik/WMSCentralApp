package com.example.wmscentralapp.PickingItemScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.SuggestedItemAdapter
import com.example.wmscentralapp.Model.SuggestedData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_suggested_item.*

class SuggestedItemActivity : AppCompatActivity() {

    lateinit var suggesteditemadapter:SuggestedItemAdapter
     var itemSuggestDetailsList: ArrayList<SuggestedData> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggested_item)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_scan.setOnClickListener {
            onBackPressed()
            intent.putExtra("prinRequest","")
            return@setOnClickListener
        }

        suggesteditemadapter = SuggestedItemAdapter(this,itemSuggestDetailsList)
        rvSuggestedItemList.adapter = suggesteditemadapter
        prepareSuggestedData()
    }

    private fun prepareSuggestedData() {
        var suggestedData = SuggestedData("140-674","6","0","6","A-5-26-2","6")
        itemSuggestDetailsList.add(suggestedData)

        suggestedData = SuggestedData("150-151","18","1","17","A-2-04-3","113")
        itemSuggestDetailsList.add(suggestedData)

        suggestedData = SuggestedData("140-674","6","0","6","A-5-26-2","6")
        itemSuggestDetailsList.add(suggestedData)

        suggestedData = SuggestedData("140-674","6","0","6","A-5-26-2","6")
        itemSuggestDetailsList.add(suggestedData)

        suggestedData = SuggestedData("140-674","6","0","6","A-5-26-2","6")
        itemSuggestDetailsList.add(suggestedData)

        suggestedData = SuggestedData("140-674","6","0","6","A-5-26-2","6")
        itemSuggestDetailsList.add(suggestedData)

        suggestedData = SuggestedData("140-674","6","0","6","A-5-26-2","6")
        itemSuggestDetailsList.add(suggestedData)

        suggesteditemadapter.notifyDataSetChanged()
    }
}