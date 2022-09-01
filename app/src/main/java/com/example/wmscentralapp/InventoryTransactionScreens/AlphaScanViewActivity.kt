package com.example.wmscentralapp.InventoryTransactionScreens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wmscentralapp.Adapter.AlphaScanAdapter
import com.example.wmscentralapp.Model.AlphaScanData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_alpha_scan_view.*
import kotlinx.android.synthetic.main.activity_picking_item_available.*
import kotlinx.android.synthetic.main.activity_receive_container.*
import java.util.*


class AlphaScanViewActivity : AppCompatActivity() {

    var itemList: ArrayList<AlphaScanData> = ArrayList()
    lateinit var adapter: AlphaScanAdapter
    var data = AlphaScanData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alpha_scan_view)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_AlphaScan_Btn.setOnClickListener {

                onBackPressed()
                return@setOnClickListener


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
        if (srsearchBar.text.isNotEmpty()){
            searchBar_Close.visibility = View.VISIBLE
        }else{
            searchBar_Close.visibility = View.GONE
        }

        searchBar_Close.setOnClickListener {
            srsearchBar.text.clear()
            searchBar_Close.visibility = View.GONE
        }

        srsearchBar.doOnTextChanged { text, _, _, _ ->
            val array = arrayOf(itemList)

            val query= text.toString().toLowerCase(Locale.getDefault())


            val find = query
            val found = Arrays.stream(array).anyMatch{t -> t == text}
            if (query != ""){
                filterWithQuery(query)

            }else{
                attachAdapter(itemList)
                no_search_results_found_text.visibility = View.GONE
            }

        }



        attachAdapter(itemList)
        prepareItemData()

        d("itemlist","--after attach ${itemList.toString()}")
        d("itemlist","--after attach onsize ${itemList.size}")
    }

/*    fun addTextListener() {
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(query: CharSequence, start: Int, before: Int, count: Int) {
                var query = query
                query = query.toString().lowercase(Locale.getDefault())
                val filteredList: MutableList<AlphaScanData> = ArrayList()
                for (i in 0 until itemList.size) {
                    val text: kotlin.String = itemList.get(i).toString().toLowerCase()
                    if (text.contains(query)) {
                        filteredList.add(itemList.get(i))
                    }
                }
                attachAdapter(itemList)
                //prepareItemData()
            }
        })
    }*/

     fun attachAdapter(itemList: ArrayList<AlphaScanData>) {
        adapter = AlphaScanAdapter(this,itemList)
        rvAlphaListItem.adapter = adapter

    }


    private fun filterWithQuery(query: kotlin.String) {
        if (query.isNotEmpty()) {
            val filteredList: ArrayList<AlphaScanData> = onFilterChanged(query)
            d("itemlist","--filter ${filteredList.toString()}")
            d("itemlist","--filter size ${filteredList.size}")

            attachAdapter(filteredList)
            toggleRecyclerView(itemList)

        } else if (query.isEmpty()) {
            attachAdapter(itemList)

        //    adapter.filterList(itemList)
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
        if (itemList.isEmpty() || searchBar.text.isEmpty() ) {
            rvAlphaListItem.visibility = View.INVISIBLE
            no_search_results_found_text.visibility = View.GONE
        } else if(itemList.isNotEmpty() ||searchBar.text.isEmpty()){
            rvAlphaListItem.visibility = View.VISIBLE
            no_search_results_found_text.visibility = View.GONE
        }else{
            rvAlphaListItem.visibility = View.VISIBLE
            no_search_results_found_text.visibility = View.INVISIBLE
        }
    }

    private fun prepareItemData() {
        var piaData = AlphaScanData("A5080","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("B5081","H RUSTIC DOTS")
        itemList.add(piaData)


        piaData = AlphaScanData("C5082","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("D5084","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("E5084","H RUSTIC DOTS")
        itemList.add(piaData)
        piaData = AlphaScanData("F5084","H RUSTIC DOTS")
        itemList.add(piaData)

        adapter.notifyDataSetChanged()

    }
}