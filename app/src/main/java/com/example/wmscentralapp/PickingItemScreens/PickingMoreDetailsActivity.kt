package com.example.wmscentralapp.PickingItemScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_picking_more_details.*

class PickingMoreDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_more_details)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_more.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }
    }
}