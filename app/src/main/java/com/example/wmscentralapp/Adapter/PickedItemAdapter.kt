package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.wmscentralapp.Model.PickReviewData
import com.example.wmscentralapp.Model.PickedItemData
import com.example.wmscentralapp.PackOderScreens.PickingItem.PickOderItemActivity
import com.example.wmscentralapp.PickingItemScreens.PickingDetailReviewActivity
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ItemPickedBinding
import com.example.wmscentralapp.databinding.ItemReviewPickBinding

class PickedItemAdapter:RecyclerView.Adapter<PickedItemAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var pickedItemList: ArrayList<PickedItemData>

    constructor()
    constructor(context: Context, pickedItemList: ArrayList<PickedItemData>
    ) {
        this.context = context
        this.pickedItemList = pickedItemList
    }

    class ViewHolder(val binding:ItemPickedBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPickedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(pickedItemList[position]){
                binding.ordNo.text = orderno
                binding.scannDate.text = scandate
                binding.scanTime.text = scantime


                val order = SharePref.getStringValue(context,"order")
                val inventory = SharePref.getStringValue(context,"inventory")


                binding.itemPickedView.setOnClickListener {
                    Toast.makeText(context,"Orderno $orderno", Toast.LENGTH_LONG).show()
                        val i = Intent(context, PickOderItemActivity::class.java)
                        i.putExtra("OrderNo","$orderno")
                        context.startActivity(i)

                    }

            }
        }
    }

    override fun getItemCount(): Int {
        return  pickedItemList.size
    }
}