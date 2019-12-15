package com.example.home.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val numberOne = MutableLiveData<Int>()
    private val numberTwo = MutableLiveData<Int>()

    val sumResult = MediatorLiveData<Int>().apply {
        postValue(0)
    }

    init {
        sumResult.addSource(numberOne) {
            sumResult.value = sumResult.value?.plus(it)
        }

        sumResult.addSource(numberTwo) {
            sumResult.value = sumResult.value?.plus(it)
        }
    }

    fun addNumberOne() {
        numberOne.value = 1
    }

    fun addNumberTwo() {
        numberOne.value = 2
    }

    fun getInfo(): String {
        return "Hai"
    }
}