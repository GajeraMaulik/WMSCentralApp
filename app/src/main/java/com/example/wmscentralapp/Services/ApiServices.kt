package com.example.wmscentralapp.Services

import android.text.Editable
import com.example.userlogindemo.XmlParsingWithApi.Users
import com.example.wmscentralapp.OrderCommentModel.OrderCommentsListResponse
import com.example.wmscentralapp.PickOrderScreens.Zwms
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServices {

    // login api
    // http://192.168.60.9:7741/zwms/wmsrequest?action=User&usr=zc&pwd=zyber
    @GET("wmsrequest")
    @Headers(
        "accept:application/xml",

        )
    fun xmllogin(
        @Query("action") user:String,
        @Query("usr") username: Editable,
        @Query("pwd") password: Editable
    ): Call<Users>


    // pockorder api
    // http://192.168.60.9:7741/zwms/wmsrequest?action=LoadPickingOrder&order=66666666
    @GET("wmsrequest")
    @Headers(
        "accept:application/xml",
        )
    fun pickpOrder(
        @Query("action") action:String,
        @Query("order") oderNo: Editable,
    ): Call<Zwms>

    // order comment api
    // http://192.168.60.9:7741/zwms/wmsrequest?action=OrderComments&ord_no=66666666
    @GET("wmsrequest")
    @Headers(
        "accept:application/xml",
    )
    fun commentOder(
        @Query("action") action:String,
        @Query("ord_no") oderNo: String,
    ): Call<OrderCommentsListResponse>
}