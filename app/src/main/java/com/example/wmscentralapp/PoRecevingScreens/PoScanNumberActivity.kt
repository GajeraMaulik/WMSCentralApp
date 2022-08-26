package com.example.wmscentralapp.PoRecevingScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_po_receving_list.*
import kotlinx.android.synthetic.main.activity_po_scan_number.*

class PoScanNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_po_scan_number)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val list = intent.getStringExtra("list")

        if (list != ""){
            poListLabel.text = list

        }else{
            poListLabel.text = list
        }



        back_PoNo_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

    }
}