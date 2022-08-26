package com.example.wmscentralapp.PoRecevingScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_po_shipping_detail.*

class PoShippingDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_po_shipping_detail)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)


        back_posd_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }


        poReceivingSaveLabel.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

    }
}