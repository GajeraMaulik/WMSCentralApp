package com.example.wmscentralapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.LocationData
import com.example.wmscentralapp.databinding.ItemLocationBinding


class ChangeLocationAdapter: RecyclerView.Adapter<ChangeLocationAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var itemList: ArrayList<LocationData>
    private var checkedPosition = 0


    constructor()
    constructor(
        context: Context, itemList: ArrayList<LocationData>
    ) {
        this.context = context
        this.itemList = itemList
    }

    class ViewHolder(val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =  ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(itemList[position]){
                binding.location.text = location

                if (checkedPosition == -1) {
                    binding.seletedItem.setVisibility(View.GONE);
                } else {
                    if (checkedPosition == getAdapterPosition()) {
                        binding.seletedItem.setVisibility(View.VISIBLE);
                    } else {
                        binding.seletedItem.setVisibility(View.GONE);
                    }
                }


                binding.locationItem.setOnClickListener {
                    binding.seletedItem.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()  ) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                        Toast.makeText(context, "${binding.location.text}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    fun getSelected(): LocationData? {
        return if (checkedPosition != -1) {
            return  itemList.get(checkedPosition)
        } else null
    }
    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}