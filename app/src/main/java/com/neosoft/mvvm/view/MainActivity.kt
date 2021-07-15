package com.neosoft.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.neosoft.mvvm.R
import com.neosoft.mvvm.adapter.MyProductListAdapter
import com.neosoft.mvvm.constants.Constants
import com.neosoft.mvvm.repository.MainActivityRepository
import com.neosoft.mvvm.viewmodel.MainActivityViewModel
import com.neosoft.mymvvm.model.Data
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewmodel:MainActivityViewModel
    lateinit var myAdapter:MyProductListAdapter
    lateinit var list: List<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            viewmodel.getList(Constants.PRODUCT_ID)
        }
        viewmodel.getProductData().observe(this, Observer {
            list = it
            myAdapter = MyProductListAdapter(this,list)
            main_recycler_view.adapter = myAdapter
            myAdapter.notifyDataSetChanged()
        })
    }

}