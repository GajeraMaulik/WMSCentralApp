package com.example.wmscentralapp.Clp

import android.R.attr.button
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_batches.*
import kotlinx.android.synthetic.main.activity_batches.back_Batches_Btn
import kotlinx.android.synthetic.main.activity_receive_container.*


class ReceiveContainerActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_container)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        dialog = Dialog(this)

        back_Batches_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        btnEnter.setOnClickListener {
            if (etOrder.text.isEmpty()){
                emptyOder()
                Toast.makeText(this,"Oder is Empty", Toast.LENGTH_LONG).show()
            }else{
                notemptyDialog()
                Toast.makeText(this,"Oder is ${etOrder.text}", Toast.LENGTH_LONG).show()
            }
        }


    }

    fun emptyOder(){

        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        title.text = "Error"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))


        testoder.text = "Order is Empty"

        testoder.gravity = Gravity.CENTER
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.GONE

//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Ok"


        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
        params.height = height / 15 // 10%

        params.width = width * 70 / 100 // 20%

        okbtn.setLayoutParams(params)


        okbtn.setOnClickListener {
           dialog.dismiss()
        }



        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun notemptyDialog(){

        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        title.text = "Confimation"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))


        testoder.text = "Not all item picked submit as is or\n" +
                "go back and abjust the order."

        testoder.gravity = Gravity.CENTER
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.VISIBLE
        tvOrder.visibility = View.VISIBLE

        tvOrder.setText(etOrder.text)
//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Cancel"

        cancelbtn.text = "Confirm"


        okbtn.setOnClickListener {
            dialog.dismiss()
            tvOrder.visibility = View.GONE
        }
        cancelbtn.setOnClickListener {
           dialog.dismiss()
            messageOder()
        }


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun messageOder(){

        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        title.text = "Message"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))


        testoder.text = "Container recived"

        testoder.gravity = Gravity.CENTER
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.GONE
        tvOrder.visibility = View.VISIBLE
        tvOrder.setText(etOrder.text)
//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Ok"

        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
        params.height = height / 15 // 10%

        params.width = width * 70 / 100 // 20%

        okbtn.setLayoutParams(params)

        okbtn.setOnClickListener {
            dialog.dismiss()
            tvOrder.visibility = View.GONE
        }



        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

}