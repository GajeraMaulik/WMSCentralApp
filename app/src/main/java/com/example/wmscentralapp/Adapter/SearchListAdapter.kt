package com.example.wmscentralapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.SearchData
import com.example.wmscentralapp.Model.SuggestedData
import com.example.wmscentralapp.databinding.ItemSearchBinding
import com.example.wmscentralapp.databinding.ItemSuggestedBinding

class SearchListAdapter: RecyclerView.Adapter<SearchListAdapter.ViewHolder> {



    lateinit var context: Context
    var searchList :    ArrayList<SearchData> = ArrayList()


    constructor()
    constructor(
        context: Context, searchList: ArrayList<SearchData>
    ) {
        this.context = context
        this.searchList = searchList
    }

    fun setContentList(list: ArrayList<SearchData>) {
        this.searchList = list
        notifyDataSetChanged()
    }


    class ViewHolder(val binding: ItemSearchBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(searchList[position]){
                binding.SearchValue.text = searchItem
            }
        }
    }

    override fun getItemCount(): Int {
        return searchList.size
    }
}