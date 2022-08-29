package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.PickingItemScreens.PickingItemAvailableActivity
import com.example.wmscentralapp.databinding.ItemBatchesBinding
import com.example.wmscentralapp.databinding.ItemsLookupBinding

class AlphaScanAdapter: RecyclerView.Adapter<AlphaScanAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var itemList: ArrayList<AlphaScanData>


    constructor()
    constructor(context: Context, itemList: ArrayList<AlphaScanData>
    ) {
        this.context = context
        this.itemList = itemList
    }

    class ViewHolder(val binding: ItemsLookupBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =  ItemsLookupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemList[position]){

                binding.itemNo.text = itemno
                binding.itemName.text = itemname

                binding.itemLookUp.setOnClickListener{
                    val i = Intent(context, PickingItemAvailableActivity::class.java)
                    i.putExtra("aItemno","$itemno")
                    context.startActivity(i)
                }

            }
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }
}