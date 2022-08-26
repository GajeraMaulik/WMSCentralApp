package com.example.wmscentralapp.PackOderScreens.PickingItem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.ReviewPickItemsAdapter
import com.example.wmscentralapp.Model.PIAData
import com.example.wmscentralapp.Model.PickReviewData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_review_pick.*

class PickReviewActivity : AppCompatActivity() {

     var itemDetailsList: ArrayList<PickReviewData> = ArrayList()
    lateinit var reviewPickItemsAdapter: ReviewPickItemsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_pick)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_review.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        reviewPickItemsAdapter = ReviewPickItemsAdapter(this,itemDetailsList)
        rvReviewPickItem.adapter = reviewPickItemsAdapter
        prepareItemData()

    }
    private fun prepareItemData() {
        var itemdata = PickReviewData(9,"J2460","B-6-13-2","1","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(0,"J2460","B-6-13-4","4","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(99,"J2460","B-6-13-6","6","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(9,"J2460","B-6-13-7","8","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(16,"J2460","B-6-13-1","7","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(15,"J2460","B-6-13-3","5","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(14,"J2460","B-6-13-5","2","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(13,"J2460","B-6-13-8","3","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(12,"J2460","B-6-13-9","10","06/14/2022","19:56")
        itemDetailsList.add(itemdata)

        itemdata = PickReviewData(22,"J2460","B-6-13-10","9","06/14/2022","19:56")
        itemDetailsList.add(itemdata)


        reviewPickItemsAdapter.notifyDataSetChanged()

    }
}