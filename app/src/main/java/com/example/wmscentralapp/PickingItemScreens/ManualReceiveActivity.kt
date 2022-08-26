package com.example.wmscentralapp.PickingItemScreens

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_manual_recive.*
import kotlinx.android.synthetic.main.activity_manual_transfer.*

class ManualReceiveActivity : AppCompatActivity() {
    var etPickId: EditText? = null
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_recive)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        dialog = Dialog(this)
        val binno = intent.getStringExtra("binNo")
        val itemno = SharePref.getStringValue(this,"itemno")

        tvItemNo_mr.text = itemno
        tvBinNo_mr.text = binno
        back_Btn_mr.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        btnSubmit_mr.setOnClickListener {

                quantityDialog()
        }
    }
    fun quantityDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        etPickId = dialog.findViewById(R.id.edOderNo)

        title.text = "Quantity"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))

        testoder.visibility = View.GONE

        //  testoder.text = "Enter your comment below"
        etPickId!!.visibility = View.VISIBLE
        etPickId!!.hint = "This Item Issue "
        etPickId!!.inputType = InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE



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
            if (etPickId!!.text.isNotEmpty()) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                commentDialog()
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Please Enter Your Quantity", Toast.LENGTH_SHORT).show()
            }
        }


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    fun commentDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        etPickId = dialog.findViewById(R.id.edOderNo)

        title.text = "Comment:"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))

        testoder.visibility = View.VISIBLE

        testoder.text = "Enter your comment below"
        etPickId!!.visibility = View.VISIBLE
        etPickId!!.hint = "Transfer other location"
        etPickId!!.inputType = InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE



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
            if (etPickId!!.text.isNotEmpty()) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                alertDialog()
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Please Enter Your Comment", Toast.LENGTH_SHORT).show()
            }
        }


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    fun alertDialog(){

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

        testoder.text = "Transfer Bin Successfully"

        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.GONE

        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
        params.height = height / 15 // 10%

        params.width = width * 50 / 100 // 20%

        okbtn.setLayoutParams(params)



//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Ok"
        okbtn.gravity = Gravity.CENTER


        okbtn.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

}