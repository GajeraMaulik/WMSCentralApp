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
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_pack_picking.*

class PackPickingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_picking)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        // val no = ord_no
        val main = "Picking"

        val stringBuilder = StringBuilder()

        title_Packoder.text = stringBuilder.append(main).append(" ")

        val pickid = intent.getStringExtra("pickId")

        pickIdNo.text = pickid
        pickIdNo1.text = pickid


        packItemLabel.setOnClickListener {
            val i = Intent(this, PackingAvailableItemActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        addBox.setOnClickListener {
            val i = Intent(this, PackAddBoxActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
            finish()
        }
        back_Packpicking_Btn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
          //  SharePref.removeSharePref(this)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            pickIdNo.text = ""
            pickIdNo1.text = ""
            startActivity(i)
            finish()

        }

        reviewBoxe.setOnClickListener {
            val i = Intent(this, ReviewBoxesActivity::class.java)
            //  SharePref.removeSharePref(this)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        completePack.setOnClickListener {
            completDialog()
        }
    }
    override fun onBackPressed() {

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    fun completDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")


        //   txt_title.text = title


        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog.setContentView(dialogBinding)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        title.text = "Not all item picked submit as is or\n" +
                "go back and abjust the order."
        title.textAlignment = View.TEXT_ALIGNMENT_CENTER
        title.textSize = 12F



        okbtn.text = "Submit"
        cancelbtn.text  = "Abjust"

        okbtn.setOnClickListener {
            submitDialog()
          dialog.dismiss()

        }

        cancelbtn.setOnClickListener {
          dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun submitDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title =dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        title.text = "Alert"

        title.setTextColor(Color.parseColor("#863B7B"))

        title.textSize = 15F
        title.visibility = View.GONE

        testoder.text = "Packed Close"

        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.GONE

//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Ok"
        okbtn.gravity = Gravity.CENTER

        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
        params.height = height / 15 // 10%

        params.width = width * 50 / 100 // 20%

        okbtn.setLayoutParams(params)


        okbtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
}