package com.example.wmscentralapp.PackOderScreens

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_pack_attach_item.*

class PackAttachItemActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_attach_item)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)




        val itemno = SharePref.getStringValue(this,"packavailableitemno")
        tvItemNo_Pai.text = itemno
    }

    fun warningDialog(){

        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        title.text = "Warning"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))


        testoder.text = "Hitting Delete will delete this box and \n" +
                "all change will be lost for this BOX\n" +
                "hitting BOX COMPLETE will\n" +
                "complete the BOX and forward to\n" +
                "shipment processing "

        testoder.gravity = Gravity.CENTER
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.VISIBLE

//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Complate"

        cancelbtn.text = "Delete"


        okbtn.setOnClickListener {
            val intent = Intent(this@PackAttachItemActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
          //  SharePref.save(this,"packavailableitemno","")
        }
        cancelbtn.setOnClickListener {
            val intent = Intent(this@PackAttachItemActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
            SharePref.save(this,"packavailableitemno","")
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }


    override fun onStart() {
        super.onStart()


             warningDialog()

         }
    }

