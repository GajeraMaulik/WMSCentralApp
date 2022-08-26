package com.example.wmscentralapp.LoginScreens

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.userlogindemo.XmlParsingWithApi.Users
import com.example.wmscentralapp.R
import com.example.wmscentralapp.Services.Client
import com.example.wmscentralapp.SharePref
import com.example.wmscentralapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    private lateinit var username: String
    private lateinit var password: String
    private var isVisiblePassword = false

    private var prg: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        listener()

    }


    private fun init() {

        val actionBar = supportActionBar
        actionBar!!.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)


        prg = ProgressDialog(this)


        etUsername.setBackgroundResource(R.drawable.edittext_selector)
        etPassword.setBackgroundResource(R.drawable.edittext_selector)

        ivEye.setOnClickListener {
            if (!isVisiblePassword) {
                etPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                ivEye.setImageResource(R.drawable.ic_visibility_on_eye)

                isVisiblePassword = true
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                ivEye.setImageResource(R.drawable.ic_visibility_off_eye)
                isVisiblePassword = false
            }
            etPassword.setSelection(etPassword.text.length)
        }

    }

    private fun listener() {

        val buttonClick = AlphaAnimation(1f, 0.8f)
        loginBtn.setOnClickListener(View.OnClickListener { v: View ->
            etUsername.clearFocus()
            etPassword.clearFocus()
            v.startAnimation(buttonClick)
            dismissKeyboard()
            username = etUsername.text.toString().trim()
            password = etPassword.text.toString()

          //  if(username.isEmpty()){
                etUsername.error = "Username required"
                etUsername.requestFocus()
        //    }else if(password.isEmpty()){
                etPassword.error = "Password required"
                etPassword.requestFocus()
          //  }else{
                logInUser()
          //  }

        })

    }

    fun logInUser(){
        val intent =Intent(this@LoginActivity, MainActivity::class.java)
      //  intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)


        Log.d("loginsreen", "api hghgn}")

        val retroInstance = Client.xmlInstance()
        val call = retroInstance.xmllogin("User",etUsername.text,etPassword.text)
        call.enqueue(object : Callback<Users> {

            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                Log.d("loginsreen", "api before  if ${response.code()}")
                Log.d("loginsreen", "message ${ response.body()}")


                if(response.isSuccessful) {

                    Log.d("loginsreen", "api after if ${response.code()}")
                    Log.d("loginsreen", "after message ${response.message()}")
                    Log.d("loginsreen", "api  if true")

                    val userinfo: Users = response.body()!!

                    Log.d("loginsreen", "userinfo ${userinfo}")



                    for (i in 0..userinfo.userInfo?.size!!-1){
                        val name = userinfo.userInfo?.get(i)!!.cus_name
                        val no = userinfo.userInfo?.get(i)!!.cus_no
                        val addr = userinfo.userInfo?.get(i)!!.addr_1

                        Log.d("loginsreen", "userinfo name ${name.toString()}")
                        Log.d("loginsreen", "userinfo no  ${no.toString()}")
                        Log.d("loginsreen", "userinfo addr  ${addr.toString()}")

                    }


                    SharePref.save(this@LoginActivity, "username", username)
               
                    Toast.makeText(this@LoginActivity, "Login success!", Toast.LENGTH_SHORT).show()

                    val intent =Intent(this@LoginActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()

                    SharePref.save(this@LoginActivity, "isLogin", true)

                } else {
                    Log.d("loginsreen", "else ${response.body()}")
              
                    Toast.makeText(this@LoginActivity,"${response.body()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
              
                Toast.makeText(this@LoginActivity,t.message, Toast.LENGTH_SHORT).show()
                Log.d("loginsreen", "--login error->$t")
            }
        })
    }
    override fun onStart() {
        super.onStart()

   /*     if(SharePref.getBooleanValue(this, "isLogin")){
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }*/
    }

    fun dismissKeyboard() {
        val imm = (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
        imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
    }

}