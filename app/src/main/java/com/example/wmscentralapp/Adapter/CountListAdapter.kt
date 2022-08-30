package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.Model.CountListData
import com.example.wmscentralapp.PickingItemScreens.PickingItemAvailableActivity
import com.example.wmscentralapp.databinding.ItemCountBinding
import com.example.wmscentralapp.databinding.ItemsLookupBinding

class CountListAdapter:RecyclerView.Adapter<CountListAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var itemList: ArrayList<CountListData>


    constructor()
    constructor(context: Context, itemList: ArrayList<CountListData>
    ) {
        this.context = context
        this.itemList = itemList
    }
    class ViewHolder(val binding: ItemCountBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =  ItemCountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemList[position]){

                binding.itemNoCount.text = itemno
                binding.binNoCount.text = binno
                binding.qtyNoCount.text = qty
                binding.tagCount.text = tagno
                binding.countDate.text = date
                binding.countTime.text = time



            }
        }
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }
}