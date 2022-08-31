package com.example.wmscentralapp.Clp

import android.R.attr.button
import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_container)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        dialog = Dialog(this)


        val title = intent.getStringExtra("rctitle")
        title_Rc.text = title

        back_Batches_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        btnEnter.setOnClickListener {
            if (etOrder.text.isEmpty()){
                if (title_Rc.text == "Your Batches"){
                       title_Rc.text = "Receive Container"
                }
                emptyOder()
                Toast.makeText(this,"Oder is Empty", Toast.LENGTH_LONG).show()
            }else if(etOrder.text.isEmpty() || title_Rc.text == "Your Batches"){
                    title_Rc.text = "Receive Container"
                    notemptyDialog()
            }else if(title_Rc.text == "Receive Container"){
                    title_Rc.text = "Your Batches"
                    notemptyDialog()
            }else {
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

        val errortitle = intent.getStringExtra("error")
        testoder.text = errortitle

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

        params.width = width * 65 / 100 // 20%

        okbtn.setLayoutParams(params)


        okbtn.setOnClickListener {
           dialog.dismiss()
        }


        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    @SuppressLint("SetTextI18n")
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

        val confimation_msg = intent.getStringExtra("confimation")

        if (title_Rc.text == "Your Batches"){
            testoder.text = "Receiving 3 PO Lines on\n " +"container : ${etOrder.text}"
        }else{
            testoder.text = confimation_msg
        }



       // testoder.text = confimation_msg

        testoder.gravity = Gravity.CENTER
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.VISIBLE
        rvSearchList.visibility = View.VISIBLE

  //      rvSearchList.setText(etOrder.text)
//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Cancel"

        cancelbtn.text = "Confirm"


        okbtn.setOnClickListener {
            dialog.dismiss()
            rvSearchList.visibility = View.GONE
        }
        cancelbtn.setOnClickListener {
           dialog.dismiss()
            messageOder()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
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
        rvSearchList.visibility = View.VISIBLE
      //  rvSearchList.setText(etOrder.text)
//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Ok"

        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
        params.height = height / 15 // 10%

        params.width = width * 65 / 100 // 20%

        okbtn.setLayoutParams(params)

        okbtn.setOnClickListener {
            dialog.dismiss()
            rvSearchList.visibility = View.GONE
        }


        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

}