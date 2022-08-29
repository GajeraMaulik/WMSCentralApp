package com.example.wmscentralapp.Fragments

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wmscentralapp.Clp.ReceiveContainerActivity
import com.example.wmscentralapp.PackOderScreens.PackOrderScanActivity
import com.example.wmscentralapp.PackOderScreens.PickingItem.PickedItemActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.PackOderScreens.PickingItem.ScanViewActivity
import com.example.wmscentralapp.PickBatchScreens.BatchesActivity
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.fragment_order_processing.*

class OrderProcessingFragment : Fragment() {

    lateinit var dialog :Dialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?=inflater.inflate(R.layout.fragment_order_processing,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inflate the layout for this fragment
     //   return inflater.inflate(R.layout.fragment_order_processing, container, false)
        val pickOder = view.findViewById<Button>(R.id.pickOder)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(requireContext())

        dialog.setContentView(dialogBinding)

        pickOder.setOnClickListener {
            Dialog()
        }

        packOrder.setOnClickListener {
            val intent = Intent(context, PackOrderScanActivity::class.java)
            intent.putExtra("pickId","Pick Id")
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()



        }

        pickBatch.setOnClickListener {
            val intent = Intent(context, BatchesActivity::class.java)

            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }

        labelPrinting.setOnClickListener {
            val intent = Intent(context, ReceiveContainerActivity::class.java)

            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            Toast.makeText(context,"Costomer Printing",Toast.LENGTH_LONG).show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        dialog.dismiss()
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }

    fun Dialog(){

        //set title for alert dialog
     //   dialog.setTitle()
        //set message for alert dialog


        val continuebtn = dialog.findViewById<Button>(R.id.btnContinue)
        val newbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        title.text = "There’s some pick didn’t submit yet Do you want pick new or continue on exist ?"

        val order = SharePref.getStringValue(requireContext(),"order")

        //  edoderno = dialog.findViewById(R.id.edOderNo)
        continuebtn.setOnClickListener {
            val intent = Intent(context, PickedItemActivity::class.java)
                intent.putExtra("order","$order")
            intent.putExtra("pickedList","Picked item List")
           // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()

        }

        newbtn.setOnClickListener {
            val intent = Intent(context, ScanViewActivity::class.java)
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()

        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }





}