package com.example.wmscentralapp.PoRecevingScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_po_receving_review_items.*

class PoRecevingReviewItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_po_receving_review_items)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Poreview_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

    }
}