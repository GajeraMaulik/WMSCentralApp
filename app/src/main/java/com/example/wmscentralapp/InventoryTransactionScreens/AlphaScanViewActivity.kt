package com.example.wmscentralapp.InventoryTransactionScreens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wmscentralapp.Adapter.AlphaScanAdapter
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.Common.Common
import com.example.wmscentralapp.Common.Common.RESULT_CODE
import com.example.wmscentralapp.Common.Common.prepareItemData
import com.example.wmscentralapp.Common.LinearLayoutManagerWithSmoothScroll
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_alpha_scan_view.*
import java.util.*


class AlphaScanViewActivity : AppCompatActivity() {

    var itemList: ArrayList<AlphaScanData> = ArrayList()
    lateinit var adapter: AlphaScanAdapter
    lateinit var linearLayout: LinearLayoutManager
    var data = AlphaScanData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alpha_scan_view)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)



        //linearLayout = LinearLayoutManagerWithSmoothScroll(this)
      //  rvAlphaListItem.layoutManager = linearLayout
      //  rvAlphaListItem.addItemDecoration(DividerItemDecoration(this,linearLayout.orientation))

        creatList()

        adapter = AlphaScanAdapter(this,itemList)
        rvAlphaListItem.adapter = adapter
        prepareItemData()



        attachAdapter(itemList)



        back_AlphaScan_Btn.setOnClickListener {

               finish()


        }

        d("itemlist","--oncreted ${itemList.toString()}")
        d("itemlist","--onsize ${itemList.size}")
   /*     list_AlphaScanLabel.setOnClickListener {
            searchBar_Close.visibility = View.VISIBLE
            characterLabal.visibility = View.VISIBLE
            rvAlphaListItem.visibility = View.VISIBLE
            list_AlphaScanLabel.visibility = View.GONE
        }*/



        val srsearchBar=findViewById<EditText>(R.id.searchBar)


        searchBar_Close.setOnClickListener {
            srsearchBar.text.clear()
            searchBar_Close.visibility = View.GONE
        }

        srsearchBar.doOnTextChanged { text, _, _, _ ->

            val query= text.toString().toLowerCase(Locale.getDefault())

            if (query != ""){
                searchBar_Close.visibility = View.VISIBLE
                filterWithQuery(query)

            }else{
                attachAdapter(itemList)
                rvAlphaListItem.visibility = View.VISIBLE
                searchBar_Close.visibility = View.GONE
                no_search_results_found_text.visibility = View.GONE
            }

        }

        d("itemlist","--after attach ${itemList.toString()}")
        d("itemlist","--after attach onsize ${itemList.size}")
    }

    fun creatList(){
        itemList = Common.prepareItemData()
        itemList = Common.sorList(itemList)
        itemList = Common.addAlphabets(itemList)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_CODE){
            if (resultCode == Activity.RESULT_OK){
                val character :String? = data?.getStringExtra("result")
                val position:Int = Common.findPositionWithName(character!!,itemList)
                rvAlphaListItem.smoothScrollToPosition(position)
            }
        }
    }

     fun attachAdapter(itemList: ArrayList<AlphaScanData>) {
        adapter = AlphaScanAdapter(this,itemList)
         linearLayout = LinearLayoutManagerWithSmoothScroll(this)
         rvAlphaListItem.layoutManager = linearLayout
         rvAlphaListItem.addItemDecoration(DividerItemDecoration(this,linearLayout.orientation))
        rvAlphaListItem.adapter = adapter

     }

    private fun filterWithQuery(query: kotlin.String) {
        if (query.isNotEmpty()) {
            val filteredList: ArrayList<AlphaScanData> = onFilterChanged(query)
            d("itemlist","--filter ${filteredList.toString()}")
            d("itemlist","--filter size ${filteredList.size}")

            if (filteredList.isEmpty()){
                if (query.isEmpty()){
                    rvAlphaListItem.visibility = View.VISIBLE
                    no_search_results_found_text.visibility = View.GONE
                }else{
                    rvAlphaListItem.visibility = View.GONE
                    no_search_results_found_text.visibility = View.VISIBLE
                }

            }else if (filteredList.isNotEmpty()){
                attachAdapter(filteredList)
                toggleRecyclerView(itemList)

            }
        }
    }

    private fun onFilterChanged(filterQuery: kotlin.String): ArrayList<AlphaScanData> {
        d("itemlist","--filter change ${itemList.toString()}")
        d("itemlist","--filter change size ${itemList.size}")
        val filteredList = ArrayList<AlphaScanData>()
        for (currentItem in itemList) {
            if (currentItem.itemno.toLowerCase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(currentItem)
            }
            d("itemlist","--filter  after ${filteredList.toString()}")
            d("itemlist","--filter after size ${filteredList.size}")
        }
       // adapter.filterList(filteredList)
        return filteredList
    }


    private fun toggleRecyclerView( itemList: ArrayList<AlphaScanData> ) {
        if (itemList.isEmpty()) {
            rvAlphaListItem.visibility = View.INVISIBLE
            no_search_results_found_text.visibility = View.VISIBLE
        } else {
            rvAlphaListItem.visibility = View.VISIBLE
            no_search_results_found_text.visibility = View.GONE
        }
    }


}