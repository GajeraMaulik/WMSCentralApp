package com.example.wmscentralapp.PackOderScreens.PickingItem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Fragments.PickingOrderDetailFragment
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_order_details.*

class PickingOrderDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)


        val fragment = PickingOrderDetailFragment()
        showFragment(fragment)

        back_Btn_scan.setOnClickListener{
            onBackPressed()
            //dialog.dismiss()
            return@setOnClickListener
        }

    }

    fun showFragment(fragment: PickingOrderDetailFragment){
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragment_main,fragment)
        fram.commit()
    }
}