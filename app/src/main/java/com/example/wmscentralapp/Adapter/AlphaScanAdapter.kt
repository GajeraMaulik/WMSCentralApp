package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.PickingItemScreens.PickingItemAvailableActivity
import com.example.wmscentralapp.databinding.ItemsLookupBinding
import java.util.*
import kotlin.collections.ArrayList

class AlphaScanAdapter: RecyclerView.Adapter<AlphaScanAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var itemList: MutableList<AlphaScanData>

    lateinit var itemListFull: ArrayList<AlphaScanData>

    constructor()
    constructor(context: Context, itemList: MutableList<AlphaScanData>
    ) {
        this.context = context
        this.itemList = itemList
        //itemListFull = ArrayList(itemList)
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

    fun filterList(filterList:MutableList<AlphaScanData>){
        itemList = filterList
        notifyDataSetChanged()
    }

/*    override fun getFilter(): Filter {
        return itemFilter
    }

    private val itemFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<AlphaScanData> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(itemListFull)
            } else {
                val filterPattern =
                    constraint.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
                for (item in itemListFull) {
                    if (item.getItemno().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
          //  itemList.clear()
            itemList.addAll(results?.values as ArrayList<AlphaScanData>)
            notifyDataSetChanged()
        }
    }*/

}


