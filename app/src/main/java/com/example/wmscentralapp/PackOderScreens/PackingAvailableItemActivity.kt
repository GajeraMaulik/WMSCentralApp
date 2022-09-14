package com.example.wmscentralapp.PackOderScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.PackAvailableAdapter
import com.example.wmscentralapp.Model.PackAvailableData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_pack_available_item.*

class PackingAvailableItemActivity : AppCompatActivity() {

    var packAvailableList: ArrayList<PackAvailableData> = ArrayList()
    lateinit var adapter: PackAvailableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pack_available_item)


        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        back_Packavailable_Btn.setOnClickListener {
          /*  val i = Intent(this, PackPickingActivity::class.java)
             i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)*/
            finish()
            Log.e("press","pressBack")
         //   onBackPressed()
          //  return@setOnClickListener

        }

        adapter = PackAvailableAdapter(this,packAvailableList)
        rvAvailableItems.adapter = adapter
        prepareItemData()


    }
    override fun onBackPressed() {

        startActivity(Intent(this, PackAddBoxActivity::class.java))
        finish()
    }

    private fun prepareItemData() {

        var packdata = PackAvailableData("F740","9","18","0","1")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("F740","2","10","0","2")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("F740","7","8","0","1")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("F740","4","2","0","2")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("F740","6","7","0","1")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("F740","10","9","0","2")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("F740","19","12","0","1")
        packAvailableList.add(packdata)

        adapter.notifyDataSetChanged()

    }
}