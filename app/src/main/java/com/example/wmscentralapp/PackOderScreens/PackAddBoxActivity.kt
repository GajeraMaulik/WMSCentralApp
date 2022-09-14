package com.example.wmscentralapp.PackOderScreens

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
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
          warningDialog()
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
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

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
        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Complate"

        cancelbtn.text = "Delete"


        okbtn.setOnClickListener {
            dialog.dismiss()
        /*   val intent = Intent(this@PackAddBoxActivity, MainActivity::class.java)
            startActivity(intent)
            finish()*/
            //  SharePref.save(this,"packavailableitemno","")
        }
        cancelbtn.setOnClickListener {
//            val intent = Intent(this@PackAddBoxActivity, MainActivity::class.java)
//            startActivity(intent)
            finish()
            super.onBackPressed()
            SharePref.save(this,"packavailableitemno","")
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    override fun onBackPressed() {
     warningDialog()
    }

    override fun onStart() {
        super.onStart()

    }

}

