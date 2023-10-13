package com.example.appiskey.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appiskey.models.GetImagesDetail
import com.example.appiskey.network.ApiInterface
import kotlinx.coroutines.launch

class HomeViewModel(val apiInterface: ApiInterface) : ViewModel() {
    private var _list: MutableLiveData<GetImagesDetail> = MutableLiveData()
    val list: LiveData<GetImagesDetail> get() = _list

    fun getImages() {
        viewModelScope.launch {
            val result = apiInterface.getImagesDetail("38437071-5f1d14114d464cb7440d92ebd","q","photo",true)
            if (result.isSuccessful){
                _list.value = result.body()
            }
        }
    }
}