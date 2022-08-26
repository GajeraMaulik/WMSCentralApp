package com.example.wmscentralapp.InventoryTransactionScreens

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.PackOderScreens.PackPickingActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_inventory_transaction.*
import kotlinx.android.synthetic.main.activity_items_scan_view.*

class ItemsScanViewActivity : AppCompatActivity() {
    var etPickId: EditText? = null
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_scan_view)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        dialog = Dialog(this)

        val title = intent.getStringExtra("ItemTitle")
        title_It_Scan.text = title

        back_ItScan_Btn.setOnClickListener {
            d("backisv","-----> bbbbbbackk")
            if (  isLItemView.visibility == View.GONE || isLFromBinView.visibility == View.GONE || title_It_Scan.text == "Issue"){
                d("backisv","---if--> bbbbbbackk")
                onBackPressed()
                return@setOnClickListener
            }else{
                d("backisv","---else--> bbbbbbackk")
               // onBackPressed()
                isLItemView.visibility = View.GONE
                isLFromBinView.visibility = View.GONE
                return@setOnClickListener
            }


        }

        list_ItScanLabel.setOnClickListener {
            if (  isLItemView.visibility == View.GONE || isLFromBinView.visibility == View.GONE || itemNo_is.text == ""){
                itemNoDialog()

            }else if(title_It_Scan.text == "Transfer"){
                fromBinDialog()
            }else{
                binNoDialog()
            }
        }

        isvManual_Btn.setOnClickListener {
            if (  isLItemView.visibility == View.GONE || isLFromBinView.visibility == View.GONE || itemNo_is.text == ""){
                itemNoDialog()

            }else if(title_It_Scan.text == "Transfer"){
                fromBinDialog()
            }else{
                binNoDialog()
            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun itemNoDialog() {

        beforeChangeColor()
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "Item No."
        title.isAllCaps = true
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        val itemno = etPickId!!.text.toString()

        SharePref.save(this, "isItemNo", "$itemno")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()
                isLItemView.visibility = View.VISIBLE
                isLFromBinView.visibility = View.VISIBLE
                itemNo_is.setText(etPickId!!.text)
                afterChangeColor()

            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
            afterChangeColor()
        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    @SuppressLint("SetTextI18n")
    fun fromBinDialog() {

        isLItemView.visibility = View.VISIBLE
        isLFromBinView.visibility = View.VISIBLE
        beforeChangeColor()
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "FROM BIN:"
        title.isAllCaps = true
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE


        etPickId!!.setText(itemNo_is.text)
        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()

                if(title_It_Scan.text == "PutWay"){
                    alertDialog()
                }else {
                    isLItemView.visibility = View.VISIBLE
                    isLFromBinView.visibility = View.VISIBLE
                    itemNo_is.setText(etPickId!!.text)
                    afterChangeColor()
                }
            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
            afterChangeColor()
        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    fun binNoDialog() {

        isLItemView.visibility = View.GONE
        isLFromBinView.visibility = View.GONE
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "Bin No:"
        title.isAllCaps = true
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        val itemno = etPickId!!.text.toString()

        SharePref.save(this, "isItemNo", "$itemno")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()
                quantityDialog()

            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
            isLItemView.visibility = View.VISIBLE
            isLFromBinView.visibility = View.VISIBLE
        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun quantityDialog() {

        isLItemView.visibility = View.GONE
        isLFromBinView.visibility = View.GONE

        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "Quantity"
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        val itemno = etPickId!!.text.toString()

        SharePref.save(this, "isItemNo", "$itemno")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()
                commentDialog()

            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun commentDialog() {

        isLItemView.visibility = View.GONE
        isLFromBinView.visibility = View.GONE

        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val tag = dialog.findViewById<TextView>(R.id.pickingItems)

        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "Comment:"
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))

        tag.text = "Enter Your Comment below"

        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
        tag.visibility = View.VISIBLE

        val itemno = etPickId!!.text.toString()

        SharePref.save(this, "isItemNo", "$itemno")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()
                alertDialog()

            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    fun alertDialog(){

        isLItemView.visibility = View.VISIBLE
        isLFromBinView.visibility = View.VISIBLE
        isLToBinno.visibility = View.VISIBLE
        beforeChangeColor()

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

        val alert = intent.getStringExtra("alert")

        when(title_It_Scan.text){
            "Issue" ->    title.text =alert
            "PutWay" ->    title.text= alert

        }


        title.setTextColor(Color.parseColor("#863B7B"))

        title.textSize = 15F

        val tran = intent.getStringExtra("transfer")

        testoder.text = tran

        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        cancelbtn.visibility = View.GONE

        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
        params.height = height / 15 // 10%

        params.width = width * 70 / 100 // 20%

        okbtn.setLayoutParams(params)


        okbtn.text = "Ok"
        okbtn.gravity = Gravity.CENTER


        okbtn.setOnClickListener {
            dialog.dismiss()
            isLItemView.visibility = View.VISIBLE
            isLFromBinView.visibility = View.VISIBLE
            isLToBinno.visibility = View.GONE
            afterChangeColor()

        }


        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun beforeChangeColor(){
        isLItemNo.setTextColor(Color.parseColor("#9B9BA3"))
        itemNo_is.setTextColor(Color.parseColor("#9B9BA3"))
        isLScanBinno.setTextColor(Color.parseColor("#9B9BA3"))
        isscanBinNo.setTextColor(Color.parseColor("#9B9BA3"))
        isLToinno.setTextColor(Color.parseColor("#9B9BA3"))
        isToBinNo.setTextColor(Color.parseColor("#9B9BA3"))
        isvManual_Btn.setTextColor(Color.parseColor("#9B9BA3"))
       // back_ItScan_Btn.setTextColor(Color.parseColor("#9B9BA3"))
        title_It_Scan.setTextColor(Color.parseColor("#9B9BA3"))
        list_ItScanLabel.setTextColor(Color.parseColor("#9B9BA3"))
    }
    fun afterChangeColor(){
        isLItemNo.setTextColor(Color.parseColor("#FFFFFF"))
        itemNo_is.setTextColor(Color.parseColor("#FFFFFF"))
        isLScanBinno.setTextColor(Color.parseColor("#FFFFFF"))
        isscanBinNo.setTextColor(Color.parseColor("#FFFFFF"))
        isLToinno.setTextColor(Color.parseColor("#FFFFFF"))
        isToBinNo.setTextColor(Color.parseColor("#FFFFFF"))
        isvManual_Btn.setTextColor(Color.parseColor("#FFFFFF"))
      //  back_ItScan_Btn.setTextColor(Color.parseColor("#FFFFFF"))
        title_It_Scan.setTextColor(Color.parseColor("#FFFFFF"))
        list_ItScanLabel.setTextColor(Color.parseColor("#FFFFFF"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, InventoryTransactionActivity::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()

    }
}