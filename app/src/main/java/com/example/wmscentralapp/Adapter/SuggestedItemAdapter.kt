package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.SuggestedData
import com.example.wmscentralapp.PickingItemScreens.PickingItemAvailableActivity
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ItemSuggestedBinding

class SuggestedItemAdapter: RecyclerView.Adapter<SuggestedItemAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var itemSuggestDetailsList: ArrayList<SuggestedData>


    constructor()
    constructor(context: Context, itemSuggestDetailsList: ArrayList<SuggestedData>
    ) {
        this.context = context
        this.itemSuggestDetailsList = itemSuggestDetailsList
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSuggestedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemSuggestDetailsList[position]){

                binding.itemNoSuggested.text = item
                binding.orderedSuggested.text = Ordered
                binding.pickedSuggested.text = Picked
                binding.remainSuggested.text = Remain
                binding.binNoSuggested.text = Binno
                binding.qtyHandSuggested.text = Qtyonhand

                binding.binNoView.setOnClickListener {
                    Toast.makeText(context,"Binno $Binno",Toast.LENGTH_LONG).show()
                    val i = Intent(context, PickingItemAvailableActivity::class.java)
                    i.putExtra("binno", Binno)
                    i.putExtra("itemno",item)
                    SharePref.save(context,"itemno",item)
                    SharePref.save(context,"binno",Binno)
                    context.startActivity(i)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return itemSuggestDetailsList.size
    }

    class ViewHolder(val binding: ItemSuggestedBinding):RecyclerView.ViewHolder(binding.root){

    }
}