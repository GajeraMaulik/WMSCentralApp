package com.example.wmscentralapp.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.Common.Common
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.Common.Common.VIEWTYPE_GROUP
import com.example.wmscentralapp.Common.Common.VIEWTYPE_ITEM
import com.example.wmscentralapp.PickingItemScreens.PickingItemAvailableActivity
import com.example.wmscentralapp.R

class AlphaScanAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {

    lateinit var context: Context
    lateinit var itemList: MutableList<AlphaScanData>



    constructor()
    constructor(context: Context, itemList: MutableList<AlphaScanData>
    ) {
        this.context = context
        this.itemList = itemList
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
            when(viewType){

                VIEWTYPE_GROUP -> {
                    val group: ViewGroup = inflater.inflate(R.layout.group_layout, parent, false) as ViewGroup
                    return GroupViewHolder(group)
                }
                VIEWTYPE_ITEM -> {
                    val group: ViewGroup =
                        inflater.inflate(R.layout.items_lookup, parent, false) as ViewGroup
                    return ItemsViewHolder(group)
                }
                else ->{
                val group:ViewGroup = inflater.inflate(R.layout.group_layout,parent,false) as ViewGroup
                return GroupViewHolder(group)
                }

             }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GroupViewHolder){
            holder.txt_group_title.text = itemList[position].itemno

            d("alphabet","**${itemList[position].itemno}")
        }
        else if (holder is ItemsViewHolder){
            val itemsViewHolder :ItemsViewHolder= holder
            itemsViewHolder.itemNo.text = itemList[position].itemno
            itemsViewHolder.itemname.text = itemList[position].itemname

            itemsViewHolder.cardView.setOnClickListener {
                val i = Intent(context, PickingItemAvailableActivity::class.java)
                i.putExtra("aItemno","${itemList.get(position).getItemno()}")
                context.startActivity(i)
            }
        }

    }




    override fun getItemViewType(position: Int): Int {
        return  itemList.get(position).viewtype
    }

   internal inner class GroupViewHolder(itemview:View): RecyclerView.ViewHolder(itemview) {
         var txt_group_title :TextView
         init {
             txt_group_title = itemview.findViewById(R.id.txt_group_title)
         }



    }
    internal inner class ItemsViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var itemNo : TextView
        var itemname : TextView
        var cardView : CardView

        init {
            itemNo  = itemview.findViewById<TextView>(R.id.itemNo)
            itemname  = itemview.findViewById<TextView>(R.id.itemName)
            cardView = itemview.findViewById<CardView>(R.id.pickedItem_View)

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}



