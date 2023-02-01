package com.example.countermvvm.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CountViewModel: ViewModel() {

    val counterData = MutableLiveData<Int>()
    val toastData = MutableLiveData<String>()
    val colorCount = MutableLiveData<Int>()
    var counter = 0

    fun increment(){
        counter++
        counterData.value = counter
    }

    fun decrement(){
        counter--
        counterData.value = counter
    }
    fun showToast(){
    if (counter == 10){
    toastData.value = counter.toString()
}
    }
    fun changeColor(){
        if (counter == 15){
            colorCount.value =counter
        }
    }

}