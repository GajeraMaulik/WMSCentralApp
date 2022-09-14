package com.example.wmscentralapp.PackOderScreens.PickingItem

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.LoginScreens.MainActivity
import com.example.wmscentralapp.OrderCommentModel.OrderCommentsListResponse
import com.example.wmscentralapp.PickOrderScreens.OrderInfo
import com.example.wmscentralapp.PickingItemScreens.PickingOrderDetailActivity
import com.example.wmscentralapp.R
import com.example.wmscentralapp.Services.Client
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_pick_oder_item.*
import kotlinx.android.synthetic.main.item_dialog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PickOderItemActivity : AppCompatActivity() {

    var ord_no:String? = null
    var orderinfo = OrderInfo()
    lateinit var dialog:Dialog
    var etPickId: EditText? = null
    var orderDetailsList :ArrayList<OrderInfo> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_oder_item)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)




        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)



        pickItems.setOnClickListener {
            val intent = Intent(this@PickOderItemActivity, PickingItemActivity::class.java)
            startActivity(intent)
        }

        reviewPickItems.setOnClickListener {
            val intent = Intent(this@PickOderItemActivity, PickReviewActivity::class.java)
            startActivity(intent)
        }

        back_Btn_scan.setOnClickListener{
            backDialog()
        //            Log.d("wms app", "---------->${onBackPressed()}")
        }

         ord_no= intent.getStringExtra( "OrderNo")

       // orderDetailsList = intent.getBundleExtra("orderdetails")

        //    userToken = SharePref.getStringValue(this, "usertoken")

        val no = ord_no
        val main = "Picking"

        val stringBuilder = StringBuilder()

        title_Pickoder.text = stringBuilder.append(main).append(" ").append(no)

        itemLabel.setOnClickListener {
            val intent = Intent(this@PickOderItemActivity, PickingOrderDetailActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
            return@setOnClickListener

        }
        submitOrder.setOnClickListener {
            submitOderDialog()
        }

        commentDialog()

    }


    fun backDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")


        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val nobtn = dialog.findViewById<Button>(R.id.btnContinue)
        val yesbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        title.text = "Picking has stareted for orders\n" +
                "$ord_no are you sure you want to \n" +
                "save?"
        title.textAlignment = View.TEXT_ALIGNMENT_CENTER
     //   title.textSize = 12F

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE




        nobtn.text = "No"
        yesbtn.text  = "Yes"

        nobtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
            ord_no = ""

        }

        yesbtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun commentDialog(){

        //set title for alert dialog
           dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnOk)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

        title.text = "Notes"
        title.textSize = 15F
        title.setTextColor(Color.parseColor("#863B7B"))

        var commentValue = SharePref.getStringValue(this@PickOderItemActivity,"comment")

        var comment = "test order"
        testoder.text = comment

        oneBtnView.visibility = View.VISIBLE
        twoBtnView.visibility = View.GONE
        testoder.visibility = View.VISIBLE



        okbtn.setOnClickListener {
          dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }


    // comment api call
    fun getComment(){
        //    val oderNo = edoderno!!.text
        val retroInstance = Client.xmlInstance()
        SharePref.save(this,"oderno","$ord_no")
        val call = retroInstance.commentOder("OrderComments",ord_no!!)

        call.enqueue(object : Callback<OrderCommentsListResponse> {
            override fun onResponse(call: Call<OrderCommentsListResponse>, response: Response<OrderCommentsListResponse>) {
                Log.d("itempick", "api before  if ${response.code()}")
                Log.d("itempick", "message ${ response.body().toString()}")

                if (response.isSuccessful){
                    val orderCommentList: OrderCommentsListResponse = response.body()!!
                    val dataclass: ArrayList<OrderCommentsListResponse> = orderCommentList.items as ArrayList<OrderCommentsListResponse>

                    for (i in 0..dataclass.size -1){
                        val ordNo = orderCommentList.items?.get(i)?.orderCommentsDTO?.get(i)?.OrdNo
                        val comment = orderCommentList.items?.get(i)?.orderCommentsDTO?.get(i)?.Comment
                        Log.d("itempick", "ord no  ${ordNo}")
                        Log.d("itempick", "comment   ${comment.toString()}")
                        SharePref.save(this@PickOderItemActivity,"comment","$comment")
                    }

                }
            }

            override fun onFailure(call: Call<OrderCommentsListResponse>, t: Throwable) {
                Log.d("itempick", "on failure  ${t}")
            }

        })

    }


    fun submitOderDialog(){

        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val logo = dialog.findViewById<ImageView>(R.id.dialog_logo)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)


        logo.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE

        title.text = "Not all items Picked. Submit As\n" +
                "is or go back and adjust the \n" +
                "order"
        title.visibility = View.VISIBLE

//        pickingItems.visibility = View.VISIBLE

        okbtn.text = "Submit"
        cancelbtn.text = "Adjust"

        okbtn.setOnClickListener {
            dialog.dismiss()
            submitDialog()
        }
    cancelbtn.setOnClickListener {
         dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun submitDialog() {

        val dialog = Dialog(this)

        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        etPickId = dialog.findViewById(R.id.edOderNo)


        title.text = "Enter Password"
        title.setTextColor(Color.parseColor("#863B7B"))

        title.gravity = Gravity.RIGHT

        testoder.visibility = View.VISIBLE
        testoder.text = "Trying to submit not fully picked order."
        etPickId!!.visibility = View.VISIBLE
        etPickId!!.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE



        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")
            if (etPickId!!.text.isNotEmpty()) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                finalSubmitDialog()
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {
            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    fun finalSubmitDialog(){

        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnOk)

        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        title.text = "Submit"
        title.textSize = 15F

        title.setTextColor(Color.parseColor("#863B7B"))


        testoder.visibility = View.GONE

        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE


        okbtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

    override fun onStart() {
        super.onStart()

        //getComment()
    }

    override fun onRestart() {
        super.onRestart()
        dialog.dismiss()
    }
    override fun onDestroy() {
        super.onDestroy()
        dialog.dismiss()
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }

}