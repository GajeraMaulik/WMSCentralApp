package com.example.wmscentralapp.InventoryTransactionScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.R
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
            i.putExtra("transfer","Transfer Bin Successfully")
            startActivity(i)
        }

        itLookUpItem_Btn.setOnClickListener {
            Toast.makeText(this,"Look Up Item", Toast.LENGTH_LONG).show()
        }

        itInventoryCount_Btn.setOnClickListener {
            Toast.makeText(this,"Inventory Count",Toast.LENGTH_LONG).show()
        }

        itChangeLocation_Btn.setOnClickListener {
            Toast.makeText(this,"Change Location",Toast.LENGTH_LONG).show()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}