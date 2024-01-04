package com.example.mvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class countViewModel : ViewModel() {
    var mutableCountData = MutableLiveData<Int>()
    init {
        mutableCountData.value = 0
    }
    fun increment (){
        mutableCountData.value = mutableCountData.value!! + 1
        // use dobble exclamation when you sure the data is not nullable
    }
    fun decrement (){
        mutableCountData.value = mutableCountData.value!! - 1
        // use dobble exclamation when you sure the data is not nullable
    }
}