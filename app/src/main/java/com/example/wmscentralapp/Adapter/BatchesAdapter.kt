package com.example.wmscentralapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.databinding.ItemBatchesBinding

class BatchesAdapter: RecyclerView.Adapter<BatchesAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var batchesList: ArrayList<String>


    constructor()
    constructor(context: Context, batchesList: ArrayList<String>
    ) {
        this.context = context
        this.batchesList = batchesList
    }

    class ViewHolder(val binding: ItemBatchesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =  ItemBatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(batchesList[position]){



            }
        }
    }

    override fun getItemCount(): Int {
        return batchesList.size
    }
}