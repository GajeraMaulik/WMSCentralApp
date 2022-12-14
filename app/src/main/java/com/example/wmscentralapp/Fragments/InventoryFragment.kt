package com.example.wmscentralapp.Fragments

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.wmscentralapp.Clp.ReceiveContainerActivity
import com.example.wmscentralapp.InventoryTransactionScreens.InventoryTransactionActivity
import com.example.wmscentralapp.PackOderScreens.PickingItem.PickedItemActivity
import com.example.wmscentralapp.PackOderScreens.PickingItem.ScanViewActivity
import com.example.wmscentralapp.PoRecevingScreens.PoRecevingListActivity
import com.example.wmscentralapp.PoRecevingScreens.PoScanNumberActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_po_scan_number.*
import kotlinx.android.synthetic.main.activity_receive_container.*
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.item_dialog.*

class InventoryFragment : Fragment() {
    lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_inventory, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(requireContext())

        dialog.setContentView(dialogBinding)

        poReceiving.setOnClickListener {
            poDialog()
            Toast.makeText(context,"Po Receiving", Toast.LENGTH_LONG).show()
        }

        inventTransaction.setOnClickListener {
            val intent = Intent(context, InventoryTransactionActivity::class.java)
            startActivity(intent)
            Toast.makeText(context,"Invent Transaction",Toast.LENGTH_LONG).show()
        }

        reciveContainer.setOnClickListener {
            Toast.makeText(context,"Recive Container",Toast.LENGTH_LONG).show()
            val intent = Intent(context, ReceiveContainerActivity::class.java)
            intent.putExtra("rctitle","Receive Container")
            intent.putExtra("error","Your order id empty")
            startActivity(intent)
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
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)

        title.text = "There???s same PO#did???t submit yet.\n Do you want pick new, or continue on\n exits?"

        val inventory = SharePref.getStringValue(requireContext(),"inventory")

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


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

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
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


