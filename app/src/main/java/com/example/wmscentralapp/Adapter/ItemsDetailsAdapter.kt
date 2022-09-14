package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PickOrderData
import com.example.wmscentralapp.PickOrderScreens.OrderInfo
import com.example.wmscentralapp.PickingItemScreens.PickingOrderDetailBinActivity
import com.example.wmscentralapp.databinding.ItemsDetailsBinding

class ItemsDetailsAdapter: RecyclerView.Adapter<ItemsDetailsAdapter.ViewHolder>  {

    lateinit var context: Context
    lateinit var itemDetailsList: ArrayList<PickOrderData>


    constructor()
    constructor(context: Context, itemDetailsList: ArrayList<PickOrderData>
    ) {
        this.context = context
        this.itemDetailsList = itemDetailsList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemDetailsList[position]){

                for (i in 0..itemDetailsList.size -1) {
                    binding.items.text = itemNo
                    binding.qty.text = qtyNo.toString()
                    binding.upc.text =  upc.toString()
                    binding.scc14.text =  ssc14
                    binding.caseNo.text =  case.toString()
                    binding.cusName.text =  cus_name
                    binding.lineNo.text =  lineNo.toString()
                    binding.qtyPicked.text = qtyPicked.toString()
                }

                binding.itemDetailView.setOnClickListener {
                    Toast.makeText(context,"$itemNo",Toast.LENGTH_LONG).show()
                        val i = Intent(context,PickingOrderDetailBinActivity::class.java)
                        context.startActivity(i)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemDetailsList.size
    }
    class ViewHolder(val binding: ItemsDetailsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}