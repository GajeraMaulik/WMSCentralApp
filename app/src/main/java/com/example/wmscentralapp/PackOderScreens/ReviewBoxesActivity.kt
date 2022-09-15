package com.example.wmscentralapp.PackOderScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.ReviewBoxesAdapter
import com.example.wmscentralapp.Model.PackAvailableData
import com.example.wmscentralapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_review_boxes.*

class ReviewBoxesActivity : AppCompatActivity() {
     var packReviewBoxesList: ArrayList<PackAvailableData> = ArrayList()

    lateinit var adapter: ReviewBoxesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_boxes)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val pickid = intent.getStringExtra("pickId")



        val main = "Box"

        val stringBuilder = StringBuilder()

        title_Reviewbox.text = stringBuilder.append(main).append(" ").append("$pickid")

        adapter = ReviewBoxesAdapter(this,packReviewBoxesList)
        rvReviewBoxesItems.adapter = adapter
        prepareItemData()

            back_Reviewboxes_Btn.setOnClickListener {
              /*  val i = Intent(this, PackPickingActivity::class.java)

                startActivity(i)*/
                finish()
            }

    }

    private fun prepareItemData() {
        var packdata = PackAvailableData("114-067","9","1","0","1")
        packReviewBoxesList.add(packdata)

        packdata = PackAvailableData("114-067","2","12","0","2")
        packReviewBoxesList.add(packdata)

        adapter.notifyDataSetChanged()
    }
    override fun onBackPressed() {

        startActivity(Intent(this, PackPickingActivity::class.java))
        finish()
    }
}