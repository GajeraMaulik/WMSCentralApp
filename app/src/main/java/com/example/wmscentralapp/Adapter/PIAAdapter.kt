package com.example.wmscentralapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PIAData
import com.example.wmscentralapp.Model.SuggestedData
import com.example.wmscentralapp.PickingItemScreens.*
import com.example.wmscentralapp.R
import com.example.wmscentralapp.databinding.ItemPickingAvailableBinding
import com.example.wmscentralapp.databinding.ItemSuggestedBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class PIAAdapter:RecyclerView.Adapter<PIAAdapter.ViewHolder> {
    lateinit var context: Context
    lateinit var itemAvailableList: ArrayList<PIAData>


    constructor()
    constructor(context: Context, itemAvailableList: ArrayList<PIAData>
    ) {
        this.context = context
        this.itemAvailableList = itemAvailableList
    }

    class ViewHolder(val binding: ItemPickingAvailableBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPickingAvailableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            with(itemAvailableList[position]) {

                binding.binNoPia.text = binno
                binding.quantityN0Pia.text = quantity

                binding.binNoPia.setOnClickListener {
                    setupBottomSheetDialog(it,binno)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemAvailableList.size
    }

    @SuppressLint("CutPasteId")
    private fun setupBottomSheetDialog(view: View,binno:String) {
        val dialog = BottomSheetDialog(context)
        dialog.setCanceledOnTouchOutside(false)

        val view = LayoutInflater.from(context).inflate(
                R.layout.item_bottom_sheet_dialog, view.findViewById<ConstraintLayout>(R.id.bottomsheet))

        view.findViewById<TextView>(R.id.bsd_Title).text = "Manual Operation"
        view.findViewById<Button>(R.id.bsd_Single).text = "Manual Issue"
        view.findViewById<Button>(R.id.bsd_Single).setOnClickListener {
            Toast.makeText(context, "Manual Issue", Toast.LENGTH_SHORT).show()
            dialog.dismiss()

            val i = Intent(context, ManualIssueActivity::class.java)
            i.putExtra("binNo",binno)
           val itemNo =  i.getStringExtra("itemno")
            i.putExtra("itemNo",itemNo)
            context.startActivity(i)
        }
        view.findViewById<Button>(R.id.bsd_Inner).text = "Manual Transfer"
        view.findViewById<Button>(R.id.bsd_Inner).setOnClickListener {
            Toast.makeText(context, "Manual Transfer", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            val i = Intent(context, ManualTransferActivity::class.java)
            i.putExtra("binNo",binno)
            val itemNo =  i.getStringExtra("itemno")
            i.putExtra("itemNo",itemNo)
            context.startActivity(i)
        }
        view.findViewById<Button>(R.id.bsd_Master).text = "Manual Receive"
        view.findViewById<Button>(R.id.bsd_Master).setOnClickListener {
            Toast.makeText(context, "Manual Recive", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            val i = Intent(context, ManualReceiveActivity::class.java)
            i.putExtra("binNo",binno)
            val itemNo =  i.getStringExtra("itemno")
            i.putExtra("itemNo",itemNo)
            context.startActivity(i)
        }
        //view.findViewById<View>(R.id.bsd_View4).visibility = View.VISIBLE
        view.findViewById<Button>(R.id.bsd_Sub).visibility = View.VISIBLE
        view.findViewById<Button>(R.id.bsd_Sub).setOnClickListener {
            Toast.makeText(context, "Manual Substitution", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            val i = Intent(context, ManualSubstitutionActivity::class.java)
            i.putExtra("binNo",binno)
            val itemNo =  i.getStringExtra("itemno")
            i.putExtra("itemNo",itemNo)
            context.startActivity(i)
        }
        view.findViewById<Button>(R.id.bsd_Cancel).setOnClickListener {
            Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
           // Dialog()
        }
        dialog.setCancelable(false)

        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)
        dialog.behavior.setPeekHeight(1500)
        dialog.show()

    }


}