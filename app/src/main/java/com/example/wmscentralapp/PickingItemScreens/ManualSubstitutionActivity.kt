package com.example.wmscentralapp.PickingItemScreens

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_manual_recive.*
import kotlinx.android.synthetic.main.activity_manual_substitution.*
import kotlinx.android.synthetic.main.item_dialog.*

class ManualSubstitutionActivity : AppCompatActivity() {
    var etPickId: EditText? = null
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_substitution)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)

        val binno = intent.getStringExtra("binNo")
        val itemno = SharePref.getStringValue(this,"itemno")

        tvItemNo_ms.text = itemno
        tvBinNo_ms.text = binno
        back_Btn_ms.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        btnSubmit_ms.setOnClickListener {
            if (tvItemNo_ms.text.isEmpty() || tvBinNo_ms.text.isEmpty()){
                tvItemNo_ms.text = itemno
                tvBinNo_ms.text = binno
                commentDialog()
            }else{
                quantityDialog()

            }
        }
    }
    fun quantityDialog(){

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

        title.text = "Quantity"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))

        testoder.visibility = View.GONE
        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE



        //  testoder.text = "Enter your comment below"
        etPickId!!.visibility = View.VISIBLE
        etPickId!!.hint = "This Item Issue "
        etPickId!!.inputType = InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE

        okbtn.setOnClickListener {
            if (etPickId!!.text.isNotEmpty()) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()

                tvItemNo_ms.setBackgroundResource(R.drawable.pd_et_bg)
                tvBinNo_ms.setBackgroundResource(R.drawable.pd_et_bg)

                tvBinNo_ms.text = ""
                tvItemNo_ms.text = ""
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Please Enter Your Quantity", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

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
        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE

        testoder.text = "Enter your comment below"
        etPickId!!.visibility = View.VISIBLE
        etPickId!!.hint = "Transfer other location"
        etPickId!!.inputType = InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE


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


        okbtn.setOnClickListener {
            dialog.dismiss()
            onBackPressed()
            return@setOnClickListener
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

}