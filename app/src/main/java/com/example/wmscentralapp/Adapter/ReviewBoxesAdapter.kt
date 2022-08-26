package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PackAvailableData
import com.example.wmscentralapp.PackOderScreens.ReviewItemsBoxActivity
import com.example.wmscentralapp.PickingItemScreens.PickingDetailReviewActivity
import com.example.wmscentralapp.databinding.ItemsReviewBoxBinding
import kotlinx.android.synthetic.main.activity_review_items_box.*

class ReviewBoxesAdapter: RecyclerView.Adapter<ReviewBoxesAdapter.ViewHolder> {
    lateinit var context: Context
    lateinit var packReviewBoxsList: ArrayList<PackAvailableData>


    constructor()
    constructor(
        context: Context, packReviewBoxsList: ArrayList<PackAvailableData>
    ) {
        this.context = context
        this.packReviewBoxsList = packReviewBoxsList
    }
    class ViewHolder(val binding: ItemsReviewBoxBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsReviewBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(packReviewBoxsList[position]) {

                binding.labelRb.text = "Box number: "

                binding.itemNoIrb.text = itemno
                binding.qtynoIrb.text = qty
                binding.lLabelReviewBox.setOnClickListener {

                    val i = Intent(context, ReviewItemsBoxActivity::class.java)
                     i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(i)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return packReviewBoxsList.size
    }

}