package com.example.wmscentralapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PIAData
import com.example.wmscentralapp.Model.PackAvailableData
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ItemPickingAvailableBinding
import com.example.wmscentralapp.databinding.ItemsPackAvailableBinding

class PackAvailableAdapter: RecyclerView.Adapter<PackAvailableAdapter.ViewHolder> {
    lateinit var context: Context
    lateinit var packAvailableList: ArrayList<PackAvailableData>


    constructor()
    constructor(context: Context,packAvailableList: ArrayList< PackAvailableData >
    ) {
        this.context = context
        this.packAvailableList = packAvailableList
    }

    class ViewHolder(val binding: ItemsPackAvailableBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsPackAvailableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(packAvailableList[position]) {

             binding.itemNoPack.text = itemno
                binding.lineNoPack.text = lineno
                binding.qtyNoPack.text = qty
                binding.qtyPickedPack.text = qtyPiked
                binding.cartonPack.text = carton

                SharePref.save(context,"packavailableitemno","$itemno")
                SharePref.save(context,"packavailableqty","$qty")

            }
        }
    }

    override fun getItemCount(): Int {
        return packAvailableList.size
    }
}