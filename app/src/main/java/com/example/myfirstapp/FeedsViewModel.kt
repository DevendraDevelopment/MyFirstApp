package com.example.myfirstapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedsViewModel : ViewModel() {

    private val _feeds = MutableLiveData<MutableList<ModeList>>()
    val feeds: LiveData<MutableList<ModeList>> = _feeds

    init {
        val initialData = mutableListOf(
            ModeList(0, "Deven"),
            ModeList(1, "Prajawal"),
            ModeList(2, "Ajay"),
            ModeList(3, "Vijay"),
            ModeList(4, "Abhay"),
            ModeList(5, "Aman"),
            ModeList(6, "Vinay"),
            ModeList(7, "Akashy")
        )
        _feeds.postValue(initialData)
    }
}