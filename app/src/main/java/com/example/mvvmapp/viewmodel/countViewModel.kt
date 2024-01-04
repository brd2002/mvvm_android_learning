package com.example.mvvmapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    var mutableCountLiveData = MutableLiveData<Int>()
    init {
        mutableCountLiveData.value = 0
    }
    fun getMutableLiveData():LiveData<Int>{
        return mutableCountLiveData
    }
    fun increment (){
        mutableCountLiveData.value = mutableCountLiveData.value!! + 1
        // use dobble exclamation when you sure the data is not nullable
    }
    fun decrement (){
        mutableCountLiveData.value = mutableCountLiveData.value!! - 1
        // use dobble exclamation when you sure the data is not nullable
    }

}