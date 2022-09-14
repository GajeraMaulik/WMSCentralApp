package com.example.wmscentralapp.PackOderScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.PackOderScreens.PickingItem.PickOderItemActivity
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_pack_review_box_detail.*

class PackReviewBoxDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_review_box_detail)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_Prbd.setOnClickListener {
          //  onBackPressed()
            finish()
        /*    val i = Intent(this, ReviewBoxesActivity::class.java)

            startActivity(i)
            return@setOnClickListener*/

        }

        val itemNo = intent.getStringExtra("itemNo")
        val qtyNo = intent.getStringExtra("qtyNo")
        val date = "07/16/2021"


        etScanDate_prbd.setText(date)
        itemNo_prbd.setText(itemNo)
        qtyNo_prbd.setText(qtyNo)


        btnDelete_prbd.setOnClickListener {
            val i = Intent(this, ReviewBoxesActivity::class.java)

            startActivity(i)
        }

        btnSave_prbd.setOnClickListener {
            val i = Intent(this, ReviewBoxesActivity::class.java)

            startActivity(i)
        }
    }
}