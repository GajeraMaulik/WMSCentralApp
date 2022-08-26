package com.example.wmscentralapp.PackOderScreens

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_box_header_details.*
import kotlinx.android.synthetic.main.activity_pack_add_box.*
import kotlinx.android.synthetic.main.activity_pack_add_box.back_Packbox_Btn
import kotlinx.android.synthetic.main.activity_pack_picking.*
import okhttp3.internal.concurrent.Task

class PackAddBoxActivity : AppCompatActivity() {

    lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_add_box)


        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        dialog = Dialog(this)



        back_Packbox_Btn.setOnClickListener {
            val i = Intent(this, PackAttachItemActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        packBoxItemLabel.setOnClickListener {
            val i = Intent(this, PackingAvailableItemActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        addItem.setOnClickListener {
            val i = Intent(this, PackOrderScanActivity::class.java)
            i.putExtra("itemId","Item ID")
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        reviewItmesBox.setOnClickListener {
            val i = Intent(this, ReviewItemsBoxActivity::class.java)
            i.putExtra("addBox","Add Box")
            startActivity(i)
        }

        boxHeaderDetails.setOnClickListener {
            val i = Intent(this, BoxHeaderDetailsActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        orderHeaderDetails.setOnClickListener {
            val i = Intent(this, BoxHeaderDetailsActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }
    }
    override fun onBackPressed() {
        val myIntent: Intent = Intent(applicationContext,  PackAttachItemActivity::class.java);
     //   myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent)
        finish()
    }

    override fun onStart() {
        super.onStart()

    }

}

