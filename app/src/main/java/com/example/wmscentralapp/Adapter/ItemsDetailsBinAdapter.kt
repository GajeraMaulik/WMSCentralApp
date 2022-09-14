package com.example.wmscentralapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PickOrderBinData
import com.example.wmscentralapp.Model.PickOrderData
import com.example.wmscentralapp.databinding.ItemsDetailsBinBinding
import com.example.wmscentralapp.databinding.ItemsDetailsBinding

class ItemsDetailsBinAdapter :RecyclerView.Adapter<ItemsDetailsBinAdapter.ViewHolder> {


    lateinit var context: Context
    lateinit var itemDetailsBinList: ArrayList<PickOrderBinData>
    constructor()
    constructor(context: Context,itemDetailsBinList:ArrayList<PickOrderBinData>){
        this.context = context
        this.itemDetailsBinList = itemDetailsBinList
    }

    class ViewHolder(val binding: ItemsDetailsBinBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsDetailsBinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemDetailsBinList[position]){

                for (i in 0..itemDetailsBinList.size -1) {
                        binding.locations.text = location
                        binding.binNo.text = binNo
                    binding.qtyOnhandNo.text = qtyOnhand.toString()
                }

                binding.itemDetailView.setOnClickListener {
                    android.widget.Toast.makeText(context,"$location", android.widget.Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
      return itemDetailsBinList.size
    }

}