package com.example.wmscentralapp.PackOderScreens

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil.inflate
import com.example.wmscentralapp.R
import com.example.wmscentralapp.databinding.ActivityBatchesBinding.inflate
import com.example.wmscentralapp.databinding.ItemBatchesBinding
import com.example.wmscentralapp.databinding.ItemsChooseDialogBinding
import kotlinx.android.synthetic.main.activity_box_header_details.*
import kotlinx.android.synthetic.main.items_choose_dialog.*

class BoxHeaderDetailsActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box_header_details)

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        val dialogBinding = layoutInflater.inflate(R.layout.item_dialog,null)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding)


        back_bhd_Btn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        packBoxSaveLabel.setOnClickListener {
            if (etPackageType.text.isEmpty()){
                Toast.makeText(this,"Please Select Package",Toast.LENGTH_LONG).show()
            }else{
                submitDialog()

            }
        }

        btnChoose.setOnClickListener {
            chooseDialog()
        }
    }
    override fun onBackPressed() {

        startActivity(Intent(this, PackAddBoxActivity::class.java))
        finish()
    }

    fun chooseDialog(){
        dialog.setContentView(R.layout.items_choose_dialog)

        dialog.cd_Pac.setOnClickListener(View.OnClickListener {
            //    d("pac","Pac :: ${cd_Pac.getText()}")

            etPackageType.setText("Package")
            dialog.dismiss()

        })

        dialog.cd_Box.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 58")
            dialog.dismiss()
        })

        dialog.cd_Box1.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 54")
            dialog.dismiss()
        })
        dialog.cd_Box2.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 40")
            dialog.dismiss()
        })
        dialog.cd_Box3.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 36")
            dialog.dismiss()
        })

        dialog.cd_Box4.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 16 Cube")
            dialog.dismiss()
        })

        dialog.cd_Box5.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 12 Cube")
            dialog.dismiss()
        })

        dialog.cd_Box6.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 10 Cube")
            dialog.dismiss()
        })

        dialog.cd_Box7.setOnClickListener(View.OnClickListener {
            etPackageType.setText("Box 7 Cube")
            dialog.dismiss()
        })

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setCancelable(true)
        dialog.show()
    }
        fun submitDialog(){

            //set title for alert dialog
            dialog.setTitle("Notes")

            //   txt_title.text = title

            //set message for alert dialog
            dialog.setContentView(R.layout.item_dialog)

            val okbtn = dialog.findViewById<Button>(R.id.btnContinue)
            val cancelbtn = dialog.findViewById<Button>(R.id.btnNew)
            val title =dialog.findViewById<TextView>(R.id.txt_pickorder_title)
            val testoder = dialog.findViewById<TextView>(R.id.pickingItems)

            title.text = "Submit Success!"

            title.setTextColor(Color.parseColor("#863B7B"))

            title.textSize = 15F

            testoder.text = "Submit Success!"

            testoder.gravity = Gravity.CENTER_HORIZONTAL
            testoder.top = 5
            testoder.visibility = View.VISIBLE
            cancelbtn.visibility = View.GONE
            okbtn.top = 5
//        pickingItems.visibility = View.VISIBLE

            okbtn.text = "Ok"
            okbtn.gravity = Gravity.CENTER

            val displayMetrics = resources.displayMetrics
            val width = displayMetrics.widthPixels
            val height = displayMetrics.heightPixels
            val params: ViewGroup.LayoutParams = okbtn.getLayoutParams()
            params.height = height / 15 // 10%

            params.width = width * 50 / 100 // 20%

            okbtn.setLayoutParams(params)


            okbtn.setOnClickListener {
                val i = Intent(this, PackPickingActivity::class.java)
                /* i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                 i.flags = Intent.FLAG_ACTIVITY_NEW_TASK*/
                startActivity(i)
            }

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.show()
            dialog.setCanceledOnTouchOutside(false)
        }


}










