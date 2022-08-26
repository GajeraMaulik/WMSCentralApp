package com.example.wmscentralapp.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.wmscentralapp.Adapter.ViewPagerAdapter
import com.example.wmscentralapp.Fragments.InventoryFragment
import com.example.wmscentralapp.Fragments.OrderProcessingFragment
import com.example.wmscentralapp.Activity.LoginActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


var userToken: String? = null
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    val orderProcessingFragment =OrderProcessingFragment()
    val inventoryFragment =InventoryFragment()


    var indicatorWidth :Int = 0
    lateinit var tablayoutmedia :TabLayoutMediator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        tabLayout = TabLayout(this)

        val username = SharePref.getStringValue(this, "username")
    //    userToken = SharePref.getStringValue(this, "usertoken")

        val user = username
        val main = "Main Menu"

        val stringBuilder = StringBuilder()

        userName.text = stringBuilder.append(main).append("(").append("user").append(")")

        viewPager = ViewPager(this)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        logOut.setOnClickListener {
              SharePref.logout(this,username)
           // SharePref.removeSharePref(this)
            userToken = ""
            SharePref.save(this, "null", userToken!!).toString()

            Log.d("dvdsfgbfdb", "main  null : $userToken")


            // sharedPrefManager.clear()
            val i = Intent(this, LoginActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
            Toast.makeText(this, "singOut $username", Toast.LENGTH_LONG).show()
            finish()
        }

        setupPagerFragment()
    }


    private fun setupPagerFragment() {

        viewPagerAdapter = ViewPagerAdapter( supportFragmentManager)
        viewPagerAdapter.addFragment(OrderProcessingFragment(),"Order Processing")
        viewPagerAdapter.addFragment(InventoryFragment(),"Inventory")
        viewPagerAdapter.getPageTitle(1)

        d("gett","--1--->${viewPagerAdapter.getPageTitle(1)}")
        d("gett","--0--->${viewPagerAdapter.getPageTitle(0)}")
        val order = viewPagerAdapter.getPageTitle(0)
        val inv = viewPagerAdapter.getPageTitle(1)

        SharePref.save(this,"order","$order")
        SharePref.save(this,"inventory","$inv")

        view_Pager.adapter = viewPagerAdapter


        tab.setupWithViewPager(view_Pager)

    }

    override fun onStart() {
        super.onStart()

      /*  if (!SharePref.getBooleanValue(this, "isLogin")) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }*/
    }



}