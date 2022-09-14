package com.example.wmscentralapp.PickingItemScreens

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_manual_issue.*
import kotlinx.android.synthetic.main.item_dialog.*

class ManualIssueActivity : AppCompatActivity() {
    var etPickId: EditText? = null
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_issue)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)


        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)

        val binno = intent.getStringExtra("binNo")
        val itemno = SharePref.getStringValue(this,"itemno")

        tvItemNo_mi.text = itemno
        tvBinNo_mi.text = binno
        back_Btn_mi.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        btnSubmit_mi.setOnClickListener {

            if (tvItemNo_mi.text.isEmpty() || tvBinNo_mi.text.isEmpty()){
                Toast.makeText(this, "Please Enter Item No and Bin No", Toast.LENGTH_SHORT).show()
            }else{
                setupDialog()
            }

        }
    }

    @SuppressLint("SetTextI18n")
    fun setupDialog() {


        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)


        title.text = "Input Quantity"

        title.gravity = Gravity.LEFT
        title.right = 10
        etPickId!!.visibility = View.VISIBLE
        etPickId!!.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL


        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")
            if (etPickId!!.text.isNotEmpty()) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                singleDialog()
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Input quantity Empty", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    fun singleDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnOk)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        etPickId = dialog.findViewById(R.id.edOderNo)

        title.text = "Comment:"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))

        testoder.visibility = View.VISIBLE

        testoder.text = "Enter your comment below"
        etPickId!!.visibility = View.VISIBLE

        etPickId!!.inputType = InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE


        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE



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

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

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

        val okbtn = dialog.findViewById<Button>(R.id.btnOk)
        val title =dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        title.text = "Alert"

        title.setTextColor(Color.parseColor("#863B7B"))

        title.textSize = 15F

        testoder.text = "Transfer Bin Successfully"

        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE
//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Ok"
        okbtn.gravity = Gravity.CENTER


        okbtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

}