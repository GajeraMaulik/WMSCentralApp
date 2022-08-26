package com.example.wmscentralapp.Fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.PackOderScreens.PickingItem.orderDeatailList
import com.example.wmscentralapp.Adapter.ItemsDetailsAdapter
import com.example.wmscentralapp.PickOrderScreens.OrderInfo
import com.example.wmscentralapp.R


class PickingOrderDetailFragment : Fragment() {
    lateinit var itemsDetailsAdapter: ItemsDetailsAdapter
    var context = Activity()
    var orderList: ArrayList<OrderInfo> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_order_detail, container, false)
        // Inflate the layout for this fragment

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()

        orderList = orderDeatailList
        setupRecyclerView(orderList)

    }

    fun setupRecyclerView(ordeList: ArrayList<OrderInfo>){
       val  recyclerView = requireView().findViewById(R.id.rvItemdetails) as RecyclerView
        itemsDetailsAdapter = ItemsDetailsAdapter(context,ordeList)
        recyclerView.adapter = itemsDetailsAdapter
    }


    fun initializeView() {
       val  recycler = requireView().findViewById(R.id.rvItemdetails) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.setHasFixedSize(true)

    }


}