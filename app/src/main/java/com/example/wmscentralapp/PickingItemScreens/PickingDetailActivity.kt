package com.example.wmscentralapp.PickingItemScreens

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import com.example.wmscentralapp.R
import com.example.wmscentralapp.SharePref
import kotlinx.android.synthetic.main.activity_pick_item.*
import kotlinx.android.synthetic.main.activity_picking_detail.*
import kotlinx.android.synthetic.main.item_dialog.*

class PickingDetailActivity : AppCompatActivity() {
    var etPickId: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_detail)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val binno =SharePref.getStringValue(this,"binno")
        val itemno = SharePref.getStringValue(this,"itemno")

        tvItemNo_pd.setText(itemNo_pd.text)
        tvBinNo_pd.setText(binNo_pd.text)
     //   tvItemScanNo_pd.text = itemno
       // tvScanBinNo_pd.text = binno
        back_Pickitem_pd_Btn.setOnClickListener {
            onBackPressed()
                intent.putExtra("prinRequest", "")
            return@setOnClickListener
        }
        submit_pd.setOnClickListener {
            submitDialog()
        }

        tvItemNo_pd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tvItemScanNo_pd.text = p0
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        tvScanBinNo_pd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tvScanBinNo_pd.text = p0
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }
    @SuppressLint("ResourceAsColor")
    fun submitDialog() {

        val dialog = Dialog(this)

        dialog.setContentView(R.layout.item_dialog)

      //  tvItemNo_pd.setBackgroundColor(R.color.back1)
      //  tvBinNo_pd.setBackgroundColor(R.color.back1)

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


        okbtn.text = "Ok"
        cancelbtn.text = "Cancel"

        okbtn.setOnClickListener {
            Log.d("oderpick", "------------>ok")
            if (etPickId!!.text.isNotEmpty()) {

                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                tvItemNo_pd.setBackgroundColor(R.color.edittext)
                tvBinNo_pd.setBackgroundColor(R.color.edittext)
            } else {
                etPickId!!.error = "Empty Field"
                Toast.makeText(this, "Input quantity Empty", Toast.LENGTH_SHORT).show()
            }
        }

        cancelbtn.setOnClickListener {

            Log.d("oderpick", "------------>cancel ")
            dialog.dismiss()
            tvItemNo_pd.setBackgroundColor(R.color.edittext)
            tvBinNo_pd.setBackgroundColor(R.color.edittext)
        }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
    }

}