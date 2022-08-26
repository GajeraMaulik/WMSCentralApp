package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PackAvailableData
import com.example.wmscentralapp.PackOderScreens.PackOrderScanActivity
import com.example.wmscentralapp.PackOderScreens.PackReviewBoxDetailActivity
import com.example.wmscentralapp.databinding.ItemsPackAvailableBinding
import com.example.wmscentralapp.databinding.ItemsReviewBoxBinding

 class PackReviewBoxAdapter: RecyclerView.Adapter<PackReviewBoxAdapter.ViewHolder> {
    lateinit var context: Context
    lateinit var packReviewBoxList: ArrayList<PackAvailableData>


    constructor()
    constructor(
        context: Context, packReviewBoxList: ArrayList<PackAvailableData>
    ) {
        this.context = context
        this.packReviewBoxList = packReviewBoxList
    }

    class ViewHolder(val binding: ItemsReviewBoxBinding) : RecyclerView.ViewHolder(binding.root) {

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val binding = ItemsReviewBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return ViewHolder(binding)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         with(holder) {
             with(packReviewBoxList[position]) {

                 binding.labelRb.text = "Item number: "
                     binding.itemNoIrb.text = itemno
                 binding.qtynoIrb.text = qty

                 binding.lLabelReviewBox.setOnClickListener {
                     val i = Intent(context, PackReviewBoxDetailActivity::class.java)
                     i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                     i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                     context.startActivity(i)
                 }
             }
         }
     }

     override fun getItemCount(): Int {
         return packReviewBoxList.size
     }

 }