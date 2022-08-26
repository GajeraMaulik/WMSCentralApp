package com.example.wmscentralapp.PickingItemScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Model.PickReviewData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_picking_detail.*
import kotlinx.android.synthetic.main.activity_picking_detail_review.*

class PickingDetailReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_detail_review)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Pickdeatail_Btn.setOnClickListener {

            val btntxt = btnSave_pdr.text.toString()
            if (btntxt.equals("EDIT")){
                onBackPressed()
                return@setOnClickListener
            }else{
                tvItemNo_pd.visibility = View.VISIBLE
                tvBinNo_pd.visibility = View.VISIBLE
                tvQtyNo_pdr.visibility = View.VISIBLE
                etItemNo_pdr.visibility = View.GONE
                etBinNo_pdr.visibility = View.GONE
                etQtyNo_pdr.visibility = View.GONE
                btnSave_pdr.text = "EDIT"
            }

        }


        var item = intent.getStringExtra("itemno")
        val bin = intent.getStringExtra("binno")
        val qty = intent.getStringExtra("qtyno")
        val date = intent.getStringExtra("date")
        val time= intent.getStringExtra("time")

        tvItemNo_pdr.text = item
        tvBinNo_pdr.text = bin
        tvQtyNo_pdr.text = qty
        tvtime_pdr.text = "$date $time"


        etItemNo_pdr.setText(item)

        btnSave_pdr.setOnClickListener {

            val btntxt = btnSave_pdr.text.toString()
            if (btntxt.equals("EDIT") ){
                tvItemNo_pdr.visibility = View.GONE
                tvBinNo_pdr.visibility = View.GONE
                tvQtyNo_pdr.visibility = View.GONE

                etItemNo_pdr.visibility = View.VISIBLE
                etBinNo_pdr.visibility = View.VISIBLE
                etQtyNo_pdr.visibility = View.VISIBLE

                etItemNo_pdr.setText(tvItemNo_pdr.text)
                etBinNo_pdr.setText(tvBinNo_pdr.text)
                etQtyNo_pdr.setText(tvQtyNo_pdr.text)

                btnSave_pdr.text = "SAVE"
            }else{
                tvItemNo_pdr.visibility = View.VISIBLE
                tvBinNo_pdr.visibility = View.VISIBLE
                tvQtyNo_pdr.visibility = View.VISIBLE

                etItemNo_pdr.visibility = View.GONE
                etBinNo_pdr.visibility = View.GONE
                etQtyNo_pdr.visibility = View.GONE

                tvItemNo_pdr.setText(etItemNo_pdr.text)
                tvBinNo_pdr.setText(etBinNo_pdr.text)
                tvQtyNo_pdr.setText(etQtyNo_pdr.text)
                btnSave_pdr.text = "EDIT"
            }


        }

        btnDelete_pdr.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

    }
}