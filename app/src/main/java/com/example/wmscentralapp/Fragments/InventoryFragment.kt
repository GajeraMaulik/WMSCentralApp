package com.example.wmscentralapp.Fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.wmscentralapp.PackOderScreens.PickingItem.PickedItemActivity
import com.example.wmscentralapp.PackOderScreens.PickingItem.ScanViewActivity
import com.example.wmscentralapp.PoRecevingScreens.PoRecevingListActivity
import com.example.wmscentralapp.PoRecevingScreens.PoScanNumberActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_po_scan_number.*
import kotlinx.android.synthetic.main.fragment_inventory.*

class InventoryFragment : Fragment() {
    lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_inventory, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog = Dialog(requireContext())

        poReceiving.setOnClickListener {
            poDialog()
            Toast.makeText(context,"Po Receiving", Toast.LENGTH_LONG).show()
        }

        inventTransaction.setOnClickListener {
            Toast.makeText(context,"Invent Transaction",Toast.LENGTH_LONG).show()
        }

        reciveContainer.setOnClickListener {
            Toast.makeText(context,"Recive Container",Toast.LENGTH_LONG).show()
        }
    }
    fun poDialog(){

        //set title for alert dialog
        //   dialog.setTitle()
        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)


        val continuebtn = dialog.findViewById<Button>(R.id.btnContinue)
        val newbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        title.text = "There’s same PO#did’t submit yet.\n Do you want pick new, or continue on\n exits?"

        val inventory = SharePref.getStringValue(requireContext(),"inventory")


        //  edoderno = dialog.findViewById(R.id.edOderNo)
        continuebtn.setOnClickListener {
            val intent = Intent(context, PoRecevingListActivity::class.java)
            intent.putExtra("inventory","$inventory")
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }


        newbtn.setOnClickListener {
            val intent = Intent(context, PoScanNumberActivity::class.java)
            intent.putExtra("list","")
            startActivity(intent)

        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)

        }
    override fun onDestroyView() {
        super.onDestroyView()
        dialog.dismiss()
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }
    }


