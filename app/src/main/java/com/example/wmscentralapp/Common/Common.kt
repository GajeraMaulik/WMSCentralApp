package com.example.wmscentralapp.Common

import android.util.Log
import com.example.wmscentralapp.Model.AlphaScanData
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

object Common {

    var VIEWTYPE_GROUP = 0
    var VIEWTYPE_ITEM = 1
    var RESULT_CODE = 1000

    val alphbetList :MutableList<String> = ArrayList()

    fun sorList(itemList :ArrayList<AlphaScanData>):ArrayList<AlphaScanData>{
        itemList.sortWith(Comparator{
            item1,item2 -> item1!!.itemno.compareTo(item2.itemno)
        })
        return  itemList



    }

    fun addAlphabets(list:ArrayList<AlphaScanData>):ArrayList<AlphaScanData>{
        var i:Int = 0
        val customList :ArrayList<AlphaScanData> = ArrayList()
        val firstLetter = AlphaScanData()
        firstLetter.itemno = list[0].itemno[0].toString()
        firstLetter.viewtype  = VIEWTYPE_GROUP
        alphbetList.add(list[0].itemno[0].toString())

        customList.add(firstLetter)
        i =0
        while (i <list.size-1){

            val data = AlphaScanData()
            val name1 :Char= list[i].itemno[0]
            val name2 :Char= list[i+1].itemno[0]

            Log.d("common", "** name 1$name1")
            Log.d("common", "** name 2 $name2")
            if(name1 == name2){
                list[i].viewtype = VIEWTYPE_ITEM
                customList.add(list[i])
            }else{
                list[i].viewtype =VIEWTYPE_ITEM
                customList.add(list[i])
                data.itemno = name2.toString()
                data.viewtype = VIEWTYPE_GROUP
                alphbetList.add(name2.toString())
                customList.add(data)

            }
            i++
        }

        list[i].viewtype = VIEWTYPE_ITEM
        customList.add(list[i])
        return customList
    }


    fun findPositionWithName(name: String,list: ArrayList<AlphaScanData>): Int {
        for (i in list.indices){
            if (list[i].itemno == name){
                return i
            }

        }
        return -1
    }

    fun genAlphabet():ArrayList<String>{
        val result :ArrayList<String> = ArrayList()
        for (i in 65..90){
            result.add((i.toChar()).toString())
        }
        return  result
    }
 fun prepareItemData() :ArrayList<AlphaScanData>{
        var itemList: ArrayList<AlphaScanData> = java.util.ArrayList()
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

        piaData = AlphaScanData("G5084","H RUSTIC DOTS")
        itemList.add(piaData)

        piaData = AlphaScanData("H5084","H RUSTIC DOTS")
        itemList.add(piaData)
     piaData = AlphaScanData("d5084","H RUSTIC DOTS")
     itemList.add(piaData)
     piaData = AlphaScanData("D5084","H RUSTIC DOTS")
     itemList.add(piaData)
        piaData = AlphaScanData("I5084","H RUSTIC DOTS")
        itemList.add(piaData)

        return itemList
    }
}