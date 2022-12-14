package com.example.wmscentralapp.PickingItemScreens

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.wmscentralapp.Adapter.PIAAdapter
import com.example.wmscentralapp.Model.PIAData
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ItemPickingAvailableBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_picking_item_available.*
import kotlinx.android.synthetic.main.item_dialog.*

class PickingItemAvailableActivity : AppCompatActivity() {

     var itemAvailableList: ArrayList<PIAData> = ArrayList()
    lateinit var adapter:PIAAdapter
    lateinit var binding: ItemPickingAvailableBinding
    var etPickId: EditText? = null
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_item_available)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)


        val itemNo = intent.getStringExtra("aItemno")
        title_Pickoder.text = itemNo


        back_Btn_Pia.setOnClickListener {
            onBackPressed()
        }


        moreDetails.setOnClickListener {
            val i = Intent(this, PickingMoreDetailsActivity::class.java)
            /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
            startActivity(i)
        }


        adapter = PIAAdapter(this,itemAvailableList)
        rvPiaList.adapter = adapter
        prepareItemData()

        print_Pia.setOnClickListener {
            setupBottomSheetDialog()
        }

    }

    private fun setupBottomSheetDialog() {
      //  setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
        val dialog = BottomSheetDialog(this)
        dialog.setCanceledOnTouchOutside(false)
        val view = LayoutInflater.from(this)
            .inflate(R.layout.item_bottom_sheet_dialog,
                findViewById<ConstraintLayout>(R.id.bottomsheet))

   //     view.setBackgroundColor(Color.parseColor("#B1000000"))
        view.findViewById<Button>(R.id.bsd_Single).setOnClickListener {
            Toast.makeText(this, "Single", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            Dialog()
        }
        view.findViewById<Button>(R.id.bsd_Inner).setOnClickListener {
            Toast.makeText(this, "Inner", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            Dialog()
        }
        view.findViewById<Button>(R.id.bsd_Master).setOnClickListener {
            Toast.makeText(this, "Master", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            Dialog()
        }
        view.findViewById<Button>(R.id.bsd_Cancel).setOnClickListener {
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)

        dialog.show()

    }
    @SuppressLint("SetTextI18n")
    fun Dialog() {


        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
        val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
        val title = dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        etPickId = dialog.findViewById(R.id.edOderNo)


        title.text = "Input Quantity"

        title.gravity = Gravity.LEFT
        title.right = 10
        etPickId!!.visibility = View.VISIBLE

        oneBtnView.visibility = View.GONE
        twoBtnView.visibility = View.VISIBLE


        SharePref.save(this,"qty","${etPickId!!.text}")


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")
            if (etPickId!!.text.isNotEmpty()) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                singleDialog()
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Input quantity Empty", Toast.LENGTH_SHORT).show()
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


    fun singleDialog(){

        val dialog = Dialog(this)
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


        testoder.text = "Request lebal to submit printer"
        testoder.visibility = View.VISIBLE

        twoBtnView.visibility = View.GONE
        oneBtnView.visibility = View.VISIBLE

        okbtn.setOnClickListener {
            dialog.dismiss()
            alertDialog()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }


    fun alertDialog(){

        val dialog = Dialog(this)
        //set title for alert dialog
        dialog.setTitle("Notes")

        //   txt_title.text = title

        //set message for alert dialog
        dialog.setContentView(R.layout.item_dialog)

        val okbtn = dialog.findViewById<Button>(R.id.btnOk)
        val title =dialog.findViewById<TextView>(R.id.txt_pickorder_title)
        val testoder = dialog.findViewById<TextView>(R.id.pickingItems)
        val oneBtnView = dialog.findViewById<LinearLayout>(R.id.oneBtnView)
        val twoBtnView = dialog.findViewById<LinearLayout>(R.id.twoBtnView)
        title.text = "Alert"

        title.text
        title.textSize = 15F

        val username = SharePref.getStringValue(this, "username")
        val qty = SharePref.getStringValue(this,"qty")
        testoder.text = "Item NO = J5043, Option: single\n" +
                "Quantity: $qty User : $username"

        testoder.gravity = Gravity.CENTER_HORIZONTAL
        testoder.visibility = View.VISIBLE
        oneBtnView.visibility = View.VISIBLE
        twoBtnView.visibility = View.GONE


        okbtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }


    private fun prepareItemData() {
        var piaData = PIAData("A-5-09-4","2")
        itemAvailableList.add(piaData)

        piaData = PIAData("A-5-09-2","6")
        itemAvailableList.add(piaData)

        piaData = PIAData("A-5-09-2","24")
        itemAvailableList.add(piaData)

        piaData = PIAData("A-5-09-4","5")
        itemAvailableList.add(piaData)

        piaData = PIAData("A-5-09-4","12")
        itemAvailableList.add(piaData)

        piaData = PIAData("A-5-09-4","10")
        itemAvailableList.add(piaData)

        adapter.notifyDataSetChanged()

    }
}