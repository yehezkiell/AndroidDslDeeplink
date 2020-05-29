package com.example.home.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.abstraction.data.TeamApiResponse
import com.example.abstraction.network.NbaApi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ExperimentalCoroutinesApi
class HomeViewModel @Inject constructor(private val nbaApi: NbaApi) : ViewModel() {
    var numberOne = MutableLiveData<Int>()
    private val numberTwo = MutableLiveData<Int>()
    private val livedataTest = MutableLiveData(3)

    var teams: LiveData<TeamApiResponse?> = flowApi()
        .flowOn(Dispatchers.IO)
        .map {
            if (!it.isSuccessful) throw RuntimeException(it.message())
            it.body()
        }.catch {
            Log.e("teamnya", it.message)
        }
        .asLiveData()

    val sumResult = MediatorLiveData<Int>().apply {
        postValue(0)
    }

    val sumData = MutableLiveData<String>()
    val sumData2 = MutableLiveData<String>()

    init {
        sumResult.addSource(numberOne) {
            sumResult.value = sumResult.value?.plus(it)
        }

        sumResult.addSource(numberTwo) {
            sumResult.value = sumResult.value?.plus(it)
        }
    }

    private suspend fun getApi() = nbaApi.getAllTeam(mapOf("page" to "1"))

    fun flowApi() = flow {
        emit(getApi())
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

    fun getProduct() {
        //SupervisorScope will not cancel children when on of them error
        viewModelScope.launch {
            supervisorScope {
                val asyncData2 = async {
                    data2()
                }

                val asyncData1 = async {
                    data1()
                }
                try {
                    sumData.postValue(asyncData1.await())
                } catch (e: Throwable) {
                    sumData.postValue("error")
                }
                sumData2.postValue(asyncData2.await())
            }
        }
    }

    //CoroutineScope will cancel children when on of them error, and we need special try catch outside the coroutinescope
    fun getProductCoroutineScope() {
        viewModelScope.launch {
            coroutineScope {
                val asyncData2 = async {
                    data2()
                }

                val asyncData1 = async {
                    data1()
                }
                try {
                    sumData.postValue(asyncData1.await())
                } catch (e: Throwable) {
                    sumData.postValue("Error")
                }

                //                    sumData2.postValue(asyncData2.await())
            }
        }
    }


    fun data1(): String {
        //        throw RuntimeException()
        return "1"
    }

    fun data2(): String {
        return "2"
    }
}