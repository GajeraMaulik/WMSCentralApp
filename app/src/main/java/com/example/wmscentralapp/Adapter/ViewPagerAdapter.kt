package com.example.wmscentralapp.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.wmscentralapp.Fragments.InventoryFragment
import com.example.wmscentralapp.Fragments.OrderProcessingFragment


//myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {
class ViewPagerAdapter(supportFragmentManager:FragmentManager,) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val mFragmegntList = ArrayList<Fragment>()
    val mFragmegntTitle = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmegntList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmegntList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmegntTitle[position]
    }

    fun addFragment(fragment: Fragment,title:String){
        mFragmegntList.add(fragment)
        mFragmegntTitle.add(title)
    }

}
