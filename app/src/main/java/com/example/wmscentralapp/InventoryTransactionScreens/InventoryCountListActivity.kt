package com.example.wmscentralapp.InventoryTransactionScreens

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.CountListAdapter
import com.example.wmscentralapp.Model.CountListData
import com.example.wmscentralapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_inventory_count_list.*
import kotlinx.android.synthetic.main.activity_items_scan_view.*
import kotlinx.android.synthetic.main.item_count.*

class InventoryCountListActivity : AppCompatActivity() {

     var itemList: ArrayList<CountListData> = ArrayList()
    lateinit var adapter:CountListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory_count_list)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Btn_Count.setOnClickListener {
            val i = Intent(this,InventoryTransactionActivity::class.java)
            startActivity(i)
            finish()
        }


        adapter = CountListAdapter(this,itemList)
        rvCountList.adapter = adapter
        prepareItemData()

        count_Add.setOnClickListener {
            countTagDialog()
        }

    }

    private fun countTagDialog() {
        beforeChangeColor()
        val dialog = BottomSheetDialog(this)
        dialog.setCanceledOnTouchOutside(false)
        val view = LayoutInflater.from(this)
            .inflate(R.layout.item_bottom_sheet_dialog,
                findViewById<ConstraintLayout>(R.id.bottomsheet))
        view.setBackgroundColor(Color.TRANSPARENT)
        view.findViewById<TextView>(R.id.bsd_Title).text = "LookUp item"
        view.findViewById<Button>(R.id.bsd_Single).text = "Count By Tag"
        view.findViewById<Button>(R.id.bsd_Single).setOnClickListener {
            Toast.makeText(this, "Count By Tag", Toast.LENGTH_SHORT).show()
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Scan Count")
            i.putExtra("scanTitle","Scanner not connected Reason\n firmware : Not Available")
            startActivity(i)
            afterChangeColor()
            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.bsd_Inner).text = "Count Without Tag"
        view.findViewById<Button>(R.id.bsd_Inner).setOnClickListener {
            Toast.makeText(this, "Count Without Tag", Toast.LENGTH_SHORT).show()
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Scan Count")
            i.putExtra("scanTitle","Scanner not connected Reason firmware : Not Available")
            startActivity(i)
            afterChangeColor()

            dialog.dismiss()
        }

        view.findViewById<Button>(R.id.bsd_Master).visibility = View.GONE
        view.findViewById<View>(R.id.bsd_View2).visibility = View.GONE

        view.findViewById<Button>(R.id.bsd_Cancel).setOnClickListener {
            afterChangeColor()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)
        dialog.show()

    }

    fun beforeChangeColor(){
        count_List_Bg.setBackgroundColor(Color.parseColor("#9B9BA3"))
        itemCount_View.setBackgroundColor(Color.parseColor("#9B9BA3"))
        itemL_Count.setTextColor(Color.parseColor("#FFFFFF"))
        qtyL_Count.setTextColor(Color.parseColor("#FFFFFF"))
        timeL_Count.setTextColor(Color.parseColor("#FFFFFF"))
        binL_Count.visibility = View.GONE
        tagL_Count.visibility = View.GONE
        recountL_Count.visibility = View.GONE

    }

    fun afterChangeColor(){
        count_List_Bg.setBackgroundColor(Color.parseColor("#FFFFFF"))
        itemCount_View.setBackgroundColor(Color.parseColor("#FFFFFF"))
        itemL_Count.setTextColor(Color.parseColor("#9B9BA3"))
        qtyL_Count.setTextColor(Color.parseColor("#9B9BA3"))
        timeL_Count.setTextColor(Color.parseColor("#9B9BA3"))
        binL_Count.visibility = View.VISIBLE
        tagL_Count.visibility = View.VISIBLE
        recountL_Count.visibility = View.VISIBLE

    }

    private fun prepareItemData() {
        var data = CountListData("J3255","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

  /*      CountListData("J3252","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3252","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3254","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3256","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3230","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3250","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3240","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)

        CountListData("J3233","A-4-24-3","1","TAG NO :8434945","07/19/2022","19:01",false)
        itemList.add(data)*/

    }
}