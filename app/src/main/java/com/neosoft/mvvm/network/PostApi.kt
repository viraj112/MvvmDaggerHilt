package com.neosoft.mvvm.network

import com.neosoft.mvvm.constants.Constants
import com.neosoft.mymvvm.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET(Constants.PRODUCT_ENDPOINT)
     suspend fun getProductList(@Query("product_category_id")product_category_id:String): ProductModel
}