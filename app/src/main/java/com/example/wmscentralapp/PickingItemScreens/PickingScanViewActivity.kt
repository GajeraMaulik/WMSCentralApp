package com.example.wmscentralapp.PackOderScreens.PickingItem

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.Adapter.ItemsDetailsAdapter
import com.example.wmscentralapp.PickOrderScreens.OrderInfo
import com.example.wmscentralapp.PickOrderScreens.Zwms
import com.example.wmscentralapp.R
import com.example.wmscentralapp.Services.Client
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ActivityScanViewBinding
import kotlinx.android.synthetic.main.activity_scan_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var orderDeatailList: ArrayList<OrderInfo> = ArrayList()

class ScanViewActivity : AppCompatActivity() {
    var edoderno: EditText? = null
    lateinit var dialog: Dialog
    lateinit var binding: ActivityScanViewBinding
    lateinit var itemsDetailsAdapter: ItemsDetailsAdapter
    var oderno: String? = null

    var orderinfo = OrderInfo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScanViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)


        back_Btn.setOnClickListener {
            onBackPressed()
            d("wms app", "---------->${onBackPressed()}")


            return@setOnClickListener
        }
        listLabel.setOnClickListener {
            Dialog()
        }

        if (oderno == ""){
            scanOderNo.text =  ""
        }else{
            oderno = SharePref.getStringValue(this, "oderno").toString()
            scanOderNo.text = oderno
        }


    }

    @SuppressLint("SetTextI18n")
    fun Dialog() {


        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)

        edoderno = dialog.findViewById(R.id.edOderNo)
        title.text = "Pick Id"


     /*   val itemId = intent.getStringExtra("itemId")
        title.text = itemId*/
      //  edOderNo.hint = itemId

        edoderno!!.visibility = View.VISIBLE


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            d("oderpick", "------------>ok")
            if (edoderno!!.text.isNotEmpty()) {
                pickOder(edoderno!!.text)
            } else {
                edoderno!!.error = "Empty Field"
                Toast.makeText(this, "Oder No Empty", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            d("oderpick", "------------>cancel ")
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog.dismiss()
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }
    override fun onBackPressed() {

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    fun pickOder(oderNo: Editable) {
        //    val oderNo = edoderno!!.text
        val retroInstance = Client.xmlInstance()
        SharePref.save(this, "oderno", "$oderNo")
        val call = retroInstance.pickpOrder("LoadPickingOrder", oderNo)

        call.enqueue(object : Callback<com.example.wmscentralapp.PickOrderScreens.Zwms> {
            override fun onResponse(
                call: Call<com.example.wmscentralapp.PickOrderScreens.Zwms>,
                zwms: Response<com.example.wmscentralapp.PickOrderScreens.Zwms>
            ) {
                Log.d("oderpick", "api before  if ${zwms.code()}")
                Log.d("oderpick", "message ${zwms.body()}")

                if (zwms.isSuccessful) {
                    val orderInfo: Zwms = zwms.body()!!

                    Log.d("oderpick", "userinfo ${orderInfo}")

                    val dataclass: ArrayList<com.example.wmscentralapp.PickOrderScreens.Zwms> =
                        orderInfo.orderInfo as ArrayList<Zwms>

                    var item :String
                    var qty :String
                    var Casepack :String
                    var name :String
                    var cusno :String
                    var itemno :String
                    var orderno :String
                    var scc14 :String
                    var lineno:String
                    var oepo :String?
                    var upccd :String
                    for (i in 0..dataclass.size - 1) {
                         item = orderInfo.orderInfo!!.get(i).item_no
                         qty = orderInfo.orderInfo!!.get(i).qty_ordered
                        Casepack = orderInfo.orderInfo!!.get(i).CasePack
                         name = orderInfo.orderInfo!!.get(i).cus_name
                         cusno = orderInfo.orderInfo!!.get(i).cus_no
                         itemno = orderInfo.orderInfo!!.get(i).item_no
                         orderno = orderInfo.orderInfo!!.get(i).ord_no
                         scc14 = orderInfo.orderInfo!!.get(i).SCC14
                         lineno = orderInfo.orderInfo!!.get(i).line_no
                         oepo = orderInfo.orderInfo!!.get(i).oe_po_no
                         upccd = orderInfo.orderInfo!!.get(i).upc_cd

                         orderinfo =OrderInfo()
                        orderinfo.setItemno(item)
                        orderinfo.setQtyord(qty)
                        orderinfo.setCasepack(Casepack)
                        orderinfo.setCusname(name)
                        orderinfo.setCusno(cusno)
                        orderinfo.setItemno(itemno)
                        orderinfo.setOrdno(orderno)
                        orderinfo.setScc14(scc14)
                        orderinfo.setLineno(lineno)
                        orderinfo.setOeponono(oepo)
                        orderinfo.setUpccd(upccd)

                        orderDeatailList.add(orderinfo)
                    }

                    d("oderpick", "--arraylist--->${orderDeatailList!!.size}")
                    d("oderpick", "--arraylist--->${orderDeatailList!!.toArray().toString()}")

                    SharePref.saveArrayList(this@ScanViewActivity, orderDeatailList!!,"orderlist")

                  //  itemsDetailsAdapter = ItemsDetailsAdapter(this@ScanViewActivity, orderDeatailList)
                    //rvItemdetails.adapter = itemsDetailsAdapter


                    val intent = Intent(this@ScanViewActivity, PickOderItemActivity::class.java)
                    intent.putExtra("orderno","$oderno")
                    startActivity(intent)

                }
            }

            override fun onFailure(
                call: Call<com.example.wmscentralapp.PickOrderScreens.Zwms>,
                t: Throwable
            ) {
                Log.d("oderpick", "on failure  ${t}")
            }

        })


    }

}
