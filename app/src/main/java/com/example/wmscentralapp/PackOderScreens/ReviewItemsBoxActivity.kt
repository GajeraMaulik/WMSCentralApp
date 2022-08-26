package com.example.wmscentralapp.PackOderScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.PackReviewBoxAdapter
import com.example.wmscentralapp.Adapter.ReviewBoxesAdapter
import com.example.wmscentralapp.Model.PackAvailableData
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ItemsReviewBoxBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pack_add_box.*
import kotlinx.android.synthetic.main.activity_review_items_box.*

class ReviewItemsBoxActivity : AppCompatActivity() {
    var packAvailableList: ArrayList<PackAvailableData> = ArrayList()
    lateinit var adapter: PackReviewBoxAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_items_box)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)



        val boxNo = SharePref.getStringValue(this, "username")
        //    userToken = SharePref.getStringValue(this, "usertoken")

        val box = boxNo
        val main = "Box"

        val stringBuilder = StringBuilder()

        title_Reviewbox.text = stringBuilder.append(main).append(" ").append(box)

   /*     val addBox = intent.getStringExtra("addBox")

        if (addBox != ""){
            reviewAddBoxItemLabel.text = addBox
        }else{
            reviewAddBoxItemLabel.text = addBox
        }
*/



        back_Reviewbox_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        reviewAddBoxItemLabel.setOnClickListener {
            val i = Intent(this, PackOrderScanActivity::class.java)
            i.putExtra("itemId","Item ID")
            i.putExtra("additem","Imput amaount blow")


            startActivity(i)
        }
        adapter = PackReviewBoxAdapter(this,packAvailableList)
        rvReviewBoxItems.adapter = adapter
        prepareItemData()


    }

    private fun prepareItemData() {
        var packdata = PackAvailableData("114-067","9","1","0","1")
        packAvailableList.add(packdata)

        packdata = PackAvailableData("114-067","2","12","0","2")
        packAvailableList.add(packdata)

        adapter.notifyDataSetChanged()

    }
}