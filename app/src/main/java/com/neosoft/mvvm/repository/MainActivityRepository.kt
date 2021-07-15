package com.neosoft.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.neosoft.mvvm.constants.Constants
import com.neosoft.mvvm.network.PostApi
import com.neosoft.mvvm.network.RetrofitInstance
import com.neosoft.mymvvm.model.Data
import com.neosoft.mymvvm.model.ProductModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityRepository @Inject constructor() {

    lateinit var list: MutableLiveData<List<Data>>

    init {
        list = MutableLiveData()
    }

    fun getlist(): MutableLiveData<List<Data>> {

        return list
    }
   suspend fun makeApicall(productId: String) {

       val retrofitInstance =
           RetrofitInstance.getRetrofitInstance().create(PostApi::class.java)

       val call = retrofitInstance.getProductList(productId)
       /* call.enqueue(object : Callback<ProductModel> {
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                try {
                    if (response.code() == Constants.SUCESS_CODE) {
                        list.postValue(response.body()?.data)
                    } else {
                        list.postValue(null)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                list.postValue(null)
            }

        })*/

       try {
           if (call.status == Constants.SUCESS_CODE) {
               list.postValue(call.data)
           } else if (call.status == Constants.ERROR_CODE){
               list.postValue(null)
           }
       } catch (e:Exception){
            e.printStackTrace()
       }
   }

}