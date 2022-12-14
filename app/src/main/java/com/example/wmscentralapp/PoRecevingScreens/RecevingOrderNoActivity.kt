package com.example.wmscentralapp.PoRecevingScreens

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.PickingItemScreens.PickingDetailReviewActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pick_item.*
import kotlinx.android.synthetic.main.activity_po_receving_list.*
import kotlinx.android.synthetic.main.activity_receving_order_no.*
import kotlinx.android.synthetic.main.activity_receving_order_no.back_Po_Btn
import kotlinx.android.synthetic.main.item_dialog.*
import java.util.*

class RecevingOrderNoActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receving_order_no)


        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)

        val orderNo = intent.getStringExtra( "poOderno")

        val no = orderNo
        val main = "Receving"

        val stringBuilder = StringBuilder()

        toolBarHeader_Ron.text = stringBuilder.append(main).append(" ").append(no)

        back_Po_Btn.setOnClickListener {
            finish()
        }

        atteachItem_btn.setOnClickListener {
            val i = Intent(this, PoScanNumberActivity::class.java)
            i.putExtra("list","List")
            startActivity(i)
        }

        reviewItemsAttached_btn.setOnClickListener {
            val i = Intent(this, PoRecevingReviewItemsActivity::class.java)
            startActivity(i)
        }
        shippingDetail_btn.setOnClickListener {
            val i = Intent(this, PoShippingDetailActivity::class.java)
            startActivity(i)
        }



        submitOrder_btn.setOnClickListener {
            warningDialog()
        }

    }

    fun warningDialog() {


        dialog.setContentView(R.layout.item_dialog)


        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val subtitle = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        title.text = "Warning"
        title.setTextColor(Color.parseColor("#863B7B"))
        subtitle.text = "No item submited"

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.GONE

        subtitle.visibility = View.VISIBLE

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)

        val handler = Handler()
        val Update = Runnable {
            if (dialog.isShowing) {

                dialog.dismiss()
            }
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.postDelayed(Update,2000)
            }
        }, 2000, 2000)


    }
}