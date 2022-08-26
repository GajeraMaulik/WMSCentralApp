package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Model.PickedItemData
import com.example.wmscentralapp.PackOderScreens.PickingItem.PickOderItemActivity
import com.example.wmscentralapp.PoRecevingScreens.RecevingOrderNoActivity
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ItemPickedBinding

class PoRecevingListAdapter : RecyclerView.Adapter<PoRecevingListAdapter.ViewHolder> {

    lateinit var context: Context
    lateinit var poRecevingList: ArrayList<PickedItemData>

    constructor()
    constructor(context: Context, poRecevingList: ArrayList<PickedItemData>) {
        this.context = context
        this.poRecevingList = poRecevingList
    }

    class ViewHolder(val binding: ItemPickedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPickedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(poRecevingList[position]){
                binding.ordNo.text = orderno
                binding.scannDate.text = scandate
                binding.scanTime.text = scantime

                binding.itemPickedView.setOnClickListener {
                    Toast.makeText(context,"Orderno $orderno", android.widget.Toast.LENGTH_LONG).show()
                    val i = Intent(context,RecevingOrderNoActivity::class.java)
                    i.putExtra("poOderno","$orderno")
                    context.startActivity(i)

                }

            }
        }
    }

    override fun getItemCount(): Int {
        return poRecevingList.size
    }


}