package com.example.wmscentralapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmscentralapp.R


class PickingOrderDetailBinFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order_detail_bin, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()


    }

    fun setupRecyclerView(){
        val  recyclerView = requireView().findViewById(R.id.rvItemdetailsBin) as RecyclerView

    }


    fun initializeView() {
        val  recycler = requireView().findViewById(R.id.rvItemdetailsBin) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.setHasFixedSize(true)

    }


}