package com.example.wmscentralapp.PackOderScreens.PickingItem

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Layout
import android.text.style.AlignmentSpan
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.PickingItemScreens.PickingDetailActivity
import com.example.wmscentralapp.PickingItemScreens.SuggestedItemActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_pick_item.*
import kotlinx.android.synthetic.main.item_dialog.*
import java.util.*

class PickingItemActivity : AppCompatActivity()  {
    var edoderno: EditText? = null
    var etPickId: EditText? = null
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_item)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)


        back_Pickitem_Btn.setOnClickListener {
            super.onBackPressed()
            /*    if (printRequestLabel.text != ""){
                    val intent = Intent(this@PickingItemActivity, SuggestedItemActivity::class.java)
                    startActivity(intent)
                }else{
                    onBackPressed()
                    return@setOnClickListener
                }*/

            }
        val print = intent.getStringExtra("prinRequest")
        printRequestLabel.text = print

        llScanItem.setOnClickListener {
            printRequestLabel.text = "Print Request"

            val itemNo = etScanItemNo.text.toString()

            itemNo_pi.text = itemNo

        }
        manual.setOnClickListener {
            val intent = Intent(this@PickingItemActivity, PickingDetailActivity::class.java)
            intent.putExtra("itemNo",itemNo_Pi.text)
            intent.putExtra("binNo",binNo.text)
            startActivity(intent)
        }

        llScanBin.setOnClickListener {
            if (printRequestLabel.text != ""){
                val scanNo = etScanBinNo.text.toString()
                scanBinNo.text = scanNo

                scanbinDialog()
            }else{
                val intent = Intent(this@PickingItemActivity, SuggestedItemActivity::class.java)
                startActivity(intent)
            }
        }

        swipeView.setOnClickListener {
            val intent = Intent(this@PickingItemActivity, SuggestedItemActivity::class.java)
            startActivity(intent)
        }

        printRequestLabel.setOnClickListener {
            setupBottomSheetDialog()
        }

    }


    private fun setupBottomSheetDialog() {
        val dialog = BottomSheetDialog(this)
        val view = LayoutInflater.from(this)
            .inflate(R.layout.item_bottom_sheet_dialog,
                findViewById<ConstraintLayout>(R.id.bottomsheet))
        view.findViewById<Button>(R.id.bsd_Single).setOnClickListener {
            Toast.makeText(this, "Single", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            printDialog()

        }
        view.findViewById<Button>(R.id.bsd_Inner).setOnClickListener {
            Toast.makeText(this, "Inner", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            printDialog()

        }
        view.findViewById<Button>(R.id.bsd_Master).setOnClickListener {
            Toast.makeText(this, "Master", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            printDialog()

        }
        view.findViewById<Button>(R.id.bsd_Cancel).setOnClickListener {
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)

        dialog.show()

    }
    @SuppressLint("SetTextI18n")
    fun printDialog() {


        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)


        title.text = "Input Quantity"

      //  title.textAlignment = View.TEXT_ALIGNMENT_VIEW_START

        etPickId!!.visibility = View.VISIBLE

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
        title.text = "Submit"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))


        testoder.text = "Request lebal to submit printer"
        testoder.visibility = View.VISIBLE

        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE



        okbtn.setOnClickListener {
            dialog.dismiss()
            alertDialog()
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

        title.text
        title.textSize = 15F

        val username = SharePref.getStringValue(this, "username")
        testoder.text = "Item NO = J5043, Option: single\n" +
                "Quantity: 1 User : $username"

        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE



        okbtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }


    @SuppressLint("SetTextI18n")
    fun scanbinDialog() {
        printRequestLabel.text = ""
        lBinno.visibility = View.VISIBLE
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        edoderno = dialog.findViewById(R.id.edOderNo)
        title.text = "Input Quantity"
        title.gravity = Gravity.LEFT

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE



        //  edOderNo.hint = itemId

        edoderno!!.visibility = View.VISIBLE


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")
            if (edoderno!!.text.isNotEmpty()) {
               // pickOder(edoderno!!.text)
                dialog.dismiss()
              NextItemDialog()
            } else {
                edoderno!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            lBinno.visibility = View.GONE
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    @SuppressLint("SetTextI18n")
    fun NextItemDialog() {


        dialog.setContentView(R.layout.item_dialog)

        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        edoderno = dialog.findViewById(R.id.edOderNo)
        title.text = "Next Item"
        title.setTextColor(Color.parseColor("#863B7B"))


        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.GONE


        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)

        val handler = Handler()
        val Update = Runnable {
            if (dialog.isShowing) {

                dialog.dismiss()
                lBinno.visibility = View.GONE
                scanBinNo.text = ""
                itemNo_pi.text = ""
            }
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.postDelayed(Update,2000)
            }
        }, 2000, 2000)


    }

    override fun onStart() {
        super.onStart()
        scanBinNo.text = ""
        itemNo_pi.text = ""
        printRequestLabel.text = ""

    }
}