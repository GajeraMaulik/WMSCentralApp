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
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_inventory_transaction.*

class InventoryTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory_transaction)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_it_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        itIssue_Btn.setOnClickListener {
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Issue")
            i.putExtra("alert","ALERT")
            i.putExtra("transfer","Transfer Bin Successfully")
            startActivity(i)
        }

        itReceive_Btn.setOnClickListener {
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Receive")
            i.putExtra("alert","ALERT")
            i.putExtra("transfer","Transfer Bin Successfully")
            startActivity(i)
        }

        itTransfer_Btn.setOnClickListener {
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Transfer")
            startActivity(i)
        }

        itPutAway_Btn.setOnClickListener {
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","PutWay")
            i.putExtra("alert","RDOCK")
            i.putExtra("transfer","The Bin number is invalid")
            startActivity(i)
        }

        itLookUpItem_Btn.setOnClickListener {
            lookUpDialog()
            Toast.makeText(this,"Look Up Item", Toast.LENGTH_LONG).show()
        }

        itInventoryCount_Btn.setOnClickListener {
            inventoryCountDialog()
            Toast.makeText(this,"Inventory Count",Toast.LENGTH_LONG).show()
        }

        itChangeLocation_Btn.setOnClickListener {
            Toast.makeText(this,"Change Location",Toast.LENGTH_LONG).show()
        }

    }

    private fun lookUpDialog() {
        val dialog = BottomSheetDialog(this)
        dialog.setCanceledOnTouchOutside(false)
        val view = LayoutInflater.from(this)
            .inflate(R.layout.item_bottom_sheet_dialog,
                findViewById<ConstraintLayout>(R.id.bottomsheet))
        view.setBackgroundColor(Color.TRANSPARENT)
        view.findViewById<TextView>(R.id.bsd_Title).text = "LookUp Item"
        view.findViewById<Button>(R.id.bsd_Single).text = "By Barcode"
        view.findViewById<Button>(R.id.bsd_Single).setOnClickListener {
            Toast.makeText(this, "By Barcode", Toast.LENGTH_SHORT).show()
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Scan view")
            startActivity(i)

            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.bsd_Inner).text = "Enter manually"
        view.findViewById<Button>(R.id.bsd_Inner).setOnClickListener {
            Toast.makeText(this, "Enter manually", Toast.LENGTH_SHORT).show()
            val i = Intent(this,ItemsScanViewActivity::class.java)
            i.putExtra("ItemTitle","Scan view")
            startActivity(i)

            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.bsd_Master).text = "Alpha"
        view.findViewById<Button>(R.id.bsd_Master).setOnClickListener {
            Toast.makeText(this, "Alpha", Toast.LENGTH_SHORT).show()
            val i = Intent(this,AlphaScanViewActivity::class.java)
            startActivity(i)
        }
        view.findViewById<Button>(R.id.bsd_Cancel).setOnClickListener {
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)
        dialog.show()

    }

    private fun inventoryCountDialog() {
        val dialog = BottomSheetDialog(this)
        dialog.setCanceledOnTouchOutside(false)
        val view = LayoutInflater.from(this)
            .inflate(R.layout.item_bottom_sheet_dialog,
                findViewById<ConstraintLayout>(R.id.bottomsheet))
        view.setBackgroundColor(Color.TRANSPARENT)
        view.findViewById<TextView>(R.id.bsd_Title).text = "LookUp Item"
        view.findViewById<Button>(R.id.bsd_Single).text = "Invetory count"
        view.findViewById<Button>(R.id.bsd_Single).setOnClickListener {
            Toast.makeText(this, "Invetory count", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.bsd_Inner).text = "Invetory recount"
        view.findViewById<Button>(R.id.bsd_Inner).setOnClickListener {
            Toast.makeText(this, "Invetory recount", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.bsd_Master).visibility = View.GONE
        view.findViewById<View>(R.id.bsd_View2).visibility = View.GONE
        view.findViewById<Button>(R.id.bsd_Master).setOnClickListener {
            Toast.makeText(this, "Alpha", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.bsd_Cancel).setOnClickListener {
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)
        dialog.show()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}