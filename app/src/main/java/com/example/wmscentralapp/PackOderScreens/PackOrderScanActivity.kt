package com.example.wmscentralapp.PackOderScreens

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_pack_order_scan.*
import kotlinx.android.synthetic.main.item_dialog.*

class PackOrderScanActivity : AppCompatActivity() {
    var etPickId: EditText? = null
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_order_scan)


        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)

        back_Pack_Btn.setOnClickListener{
            //onBackPressed()
            finish()
           // Log.d("wms app", "---------->${onBackPressed()}")
            Log.e("maulik","Backpress")

            return@setOnClickListener
        }
        pickItemLabel.setOnClickListener {
                Dialog()
        }
    }
/*    override fun onBackPressed() {
        super.onBackPressed()
  *//* startActivity(Intent(this, MainActivity::class.java))
        finish()*//*
    }*/

    @SuppressLint("SetTextI18n")
    fun Dialog() {


        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)


         val pickId = intent.getStringExtra("pickId")
        val itemId = intent.getStringExtra("itemId")

             if (pickId != null){
                title.text = pickId

            }else{
            title.text = itemId

            }



        title.gravity = Gravity.LEFT
        title.right = 10
        title.setTextColor(Color.parseColor("#863B7B"))
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


        val pickid1 = etPickId!!.text.toString()

        SharePref.save(this, "pickId", "$pickid1")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")


                if (etPickId!!.text.isNotEmpty()) {
                // pickOder(edoderno!!.text)
                    if (pickId == null){
                        dialog.dismiss()
                        inputDialog()
                        //addItemDialog()
                    }else {
                        val i = Intent(this, PackPickingActivity::class.java)
                        i.putExtra("pickId","${etPickId!!.text}")
                        /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                         i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
                        startActivity(i)
                        finish()
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

    fun inputDialog() {


        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val order = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        etPickId = dialog.findViewById(R.id.edOderNo)



        title.text = "Input amaount blow"

        title.gravity = Gravity.LEFT
        title.right = 10

        val boxtitle  = intent.getStringExtra("additem")
        order.text = boxtitle
        etPickId!!.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
        order.visibility = View.GONE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE



        val pickid  = etPickId!!.text.toString()

        SharePref.save(this,"pickId","$pickid")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            dialog.dismiss()
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }
}