package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PickReviewData
import com.example.wmscentralapp.PickingItemScreens.PickingDetailReviewActivity
import com.example.wmscentralapp.databinding.ItemReviewPickBinding

class ReviewPickItemsAdapter: RecyclerView.Adapter<ReviewPickItemsAdapter.ViewHolder>  {

    lateinit var context: Context
    lateinit var itemDetailsList: ArrayList<PickReviewData>


    constructor()
    constructor(context: Context, itemDetailsList: ArrayList<PickReviewData>
    ) {
        this.context = context
        this.itemDetailsList = itemDetailsList
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemReviewPickBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemDetailsList[position]){
                binding.itemNoReview.text = item
                binding.binNoReview.text =bin
                binding.qtyReview.text = qty
                binding.dateReview.text = date
                binding.timeReview.text = time

                binding.reviewItems.setOnClickListener {
                    Toast.makeText(context,"Binno $bin", Toast.LENGTH_LONG).show()
                    val i = Intent(context, PickingDetailReviewActivity::class.java)
                    i.putExtra("itemno", item)
                    i.putExtra("binno", bin)
                    i.putExtra("qtyno", qty)
                    i.putExtra("date", date)
                    i.putExtra("time", time)
                    context.startActivity(i)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemDetailsList.size
    }

    class ViewHolder(val binding: ItemReviewPickBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}