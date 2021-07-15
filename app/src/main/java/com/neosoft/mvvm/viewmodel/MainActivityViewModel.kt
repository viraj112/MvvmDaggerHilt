package com.neosoft.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neosoft.mvvm.repository.MainActivityRepository
import com.neosoft.mymvvm.model.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: MainActivityRepository) :
    ViewModel() {


    fun getProductData(): MutableLiveData<List<Data>> {
        return repository.getlist()
    }

    suspend fun getList(productId: String) {
        repository.makeApicall(productId)
    }

}