package com.example.wmscentralapp.InventoryTransactionScreens

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.util.Log.i
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.PackOderScreens.PackPickingActivity
import com.example.wmscentralapp.PickingItemScreens.ManualTransferActivity
import com.example.wmscentralapp.PickingItemScreens.PickingItemAvailableActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_inventory_transaction.*
import kotlinx.android.synthetic.main.activity_items_scan_view.*
import kotlinx.android.synthetic.main.item_dialog.*

class ItemsScanViewActivity : AppCompatActivity() {
     var etPickId: EditText? =null
    lateinit var dialog: Dialog
    lateinit var tagno:String
    lateinit var itemno:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_scan_view)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        tagno = ""
        itemno = ""
        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)
        etPickId =  dialog.findViewById(R.id.edOderNo)

        val title = intent.getStringExtra("ItemTitle")
        title_It_Scan.text = title

        back_ItScan_Btn.setOnClickListener {
            tagno = SharePref.getStringValue(this,"TagNo").toString()
            itemno = SharePref.getStringValue(this,"isItemNo").toString()

            d("backisv","-----> bbbbbbackk")
            if (  isLItemView.visibility == GONE || isLFromBinView.visibility == GONE || title_It_Scan.text == "Issue"){
                d("backisv","---if--> bbbbbbackk")
                super.onBackPressed()
//                return@setOnClickListener
            }else if (title_It_Scan.text == "Scan Count"){
                val i = Intent(this, InventoryCountListActivity::class.java)
                startActivity(i)
                finish()
                tagno = ""
                itemno = ""
            }
            else{
                d("backisv","---else--> bbbbbbackk")
               // onBackPressed()
                isLItemView.visibility = GONE
                isLFromBinView.visibility = GONE
                return@setOnClickListener
            }


        }


        list_ItScanLabel.setOnClickListener {
            when(title_It_Scan.text){
                "Scan Count" -> {
                    if( tagno == "") {
                        tagNoDialog()

                    }else if( itemno == ""){
                        itemNoDialog()
                    }else binNoDialog()
                }
               "Transfer" ->{
                    fromBinDialog()
                }
                else -> binNoDialog()
            }

          /*
                if (  isLItemView.visibility == GONE || isLFromBinView.visibility == GONE || itemNo_is.text == ""){

                    itemNoDialog()

                }else if(title_It_Scan.text == "Transfer"){
                    fromBinDialog()
                }else
                    binNoDialog()*/

        }




        isvManual_Btn.setOnClickListener {
            if (  isLItemView.visibility == GONE || isLFromBinView.visibility == GONE || itemNo_is.text == ""){
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

       // itemno = ""
        beforeChangeColor()

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "Item No."
        title.isAllCaps = true
        title.gravity = Gravity.LEFT
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE

        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")

            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()
                 itemno = etPickId!!.text.toString()

                SharePref.save(this, "isItemNo", "$itemno")


                if(title_It_Scan.text == "PutWay"){

                    alertDialog()
                }else if (title_It_Scan.text == "Scan view"){
                    val i = Intent(this, PickingItemAvailableActivity::class.java)
                    i.putExtra("aItemno","${etPickId!!.text}")
                    startActivity(i)
                    finish()
                } else if(title_It_Scan.text == "Scan Count"){
                    dialog.dismiss()
                    afterChangeColor()
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
            if (title_It_Scan.text == "Scan view"){
                onBackPressed()
                return@setOnClickListener
            }else {
                dialog.dismiss()
                afterChangeColor()
            }
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    @SuppressLint("SetTextI18n")
    fun fromBinDialog() {

        isLItemView.visibility = View.VISIBLE
        isLFromBinView.visibility = View.VISIBLE
        beforeChangeColor()

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)


        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


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
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun binNoDialog() {

      //  tagno =""


        isLItemView.visibility = View.VISIBLE
        isLFromBinView.visibility = View.VISIBLE

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val tag = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)

        etPickId!!.text = null


        title.text = "Bin No:"
        title.isAllCaps = true
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
        tag.visibility = GONE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


        val itemno = etPickId!!.text.toString()

//        SharePref.save(this, "isItemNo", "$itemno")


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

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun quantityDialog() {

        when(title_It_Scan.text ){
            "Receive" -> {
                isLItemView.visibility = View.VISIBLE
                isLFromBinView.visibility = View.VISIBLE
            }
            "Scan Count" ->{
                isLItemView.visibility = View.VISIBLE
                isLFromBinView.visibility = View.VISIBLE
            }
            else -> {
                isLItemView.visibility = GONE
                isLFromBinView.visibility = GONE

            }
        }



        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        val etPickId : EditText = dialog.findViewById(R.id.edOderNo)

        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)


        title.text = "Quantity"
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE

        /*      val itemno = etPickId!!.text.toString()

              SharePref.save(this, "isItemNos", "$itemno")
      */

        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId.text.isNotEmpty()) {
                dialog.dismiss()
                if (title_It_Scan.text == "Scan Count"){
                    val i = Intent(this, InventoryCountListActivity::class.java)
                    startActivity(i)
                    finish()
                }else{
                    commentDialog()

                }

            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
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

    fun commentDialog() {

        isLItemView.visibility = GONE
        isLFromBinView.visibility = GONE


        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val tag = dialog.findViewById<TextView>(R.id.pickingItems)

        val etPickId:EditText = dialog.findViewById(R.id.edOderNo)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)



        title.text = "Comment:"
        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))

        tag.text = "Enter Your Comment below"

        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
        tag.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


        val itemno = etPickId!!.text.toString()

        SharePref.save(this, "isItemNoss", "$itemno")


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
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun alertDialog(){

        isLItemView.visibility = View.VISIBLE
        isLFromBinView.visibility = View.VISIBLE
        isLToBinno.visibility = View.VISIBLE
        scanLabel_Is.top = 5
        beforeChangeColor()

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
        val alert = intent.getStringExtra("alert")
        val tran = intent.getStringExtra("transfer")

        when(title_It_Scan.text){
            "Issue" ->  { title.text =alert
                            testoder.text = tran
                        }
            "Receive" ->    {
                                title.text = alert
                                testoder.text = tran

                            }
            "PutWay" ->   {
                val itemno = SharePref.getStringValue(this,"putwayItemNo")
                itemNo_is.text = itemno
                title.text= alert
                testoder.text = tran
            }

        }



        title.setTextColor(Color.parseColor("#863B7B"))

        title.textSize = 15F



        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE



        okbtn.setOnClickListener {
            dialog.dismiss()

            if(title_It_Scan.text == "PutWay") {
                isLItemView.visibility = GONE
                isLFromBinView.visibility = GONE
                isLToBinno.visibility = GONE
                afterChangeColor()
            }else {
                isLItemView.visibility = View.VISIBLE
                isLFromBinView.visibility = View.VISIBLE
                isLToBinno.visibility = GONE
                afterChangeColor()
            }

        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

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

    fun tagNoDialog() {

       // tagno = ""
        beforeChangeColor()

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        etPickId = dialog.findViewById(R.id.edOderNo)




        title.text = "TAG NO:"
        title.isAllCaps = true
        title.gravity = Gravity.RIGHT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


            if (etPickId!!.text.isNotEmpty()) {
                dialog.dismiss()
                 tagno = etPickId!!.text.toString()

                SharePref.save(this, "TagNo", "${tagno.toString()}")

                afterChangeColor()


            }else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {

                dialog.dismiss()
                afterChangeColor()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
    override fun onStart() {
        super.onStart()
        when(title_It_Scan.text){
            "Scan view" -> itemNoDialog()
            "Scan Count" -> {
                val scanTitle = intent.getStringExtra("scanTitle")
                tvScan.text = scanTitle
                isLItemNo.text = "TAG NO :"
                isLScanBinno.text = "SCAN ORDER :"
                isLToinno.text = "FROM BIN :"
                isvManual_Btn.visibility = GONE
                isLItemView.visibility = View.VISIBLE
                isLFromBinView.visibility = View.VISIBLE
                isLToBinno.visibility = View.VISIBLE
                isLItemView.setBackgroundResource(R.drawable.countscan_bg)
                isLFromBinView.setBackgroundResource(R.drawable.countscan1_bg)
                isLToBinno.setBackgroundResource(R.drawable.countscan2_bg)
            }
        }

    }
}