package com.example.wmscentralapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.PickOrderScreens.OrderInfo
import com.example.wmscentralapp.databinding.ItemsDetailsBinding

class ItemsDetailsAdapter: RecyclerView.Adapter<ItemsDetailsAdapter.ViewHolder>  {

    lateinit var context: Context
    lateinit var itemDetailsList: ArrayList<OrderInfo>


    constructor()
    constructor(context: Context, itemDetailsList: ArrayList<OrderInfo>
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
                    binding.items.text = item_no
                    binding.qty.text = qty_ordered
                    binding.upc.text =  upc_cd
                    binding.scc14.text =  SCC14
                    binding.caseNo.text =  CasePack
                    binding.cusName.text =  cus_name
                    binding.cusNo.text =  cus_no
                    binding.lineNo.text =  line_no
                    binding.qtyPicked.text = "0"
                }

                binding.itemDetailView.setOnClickListener {
                    Toast.makeText(context,"$item_no",Toast.LENGTH_LONG).show()
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