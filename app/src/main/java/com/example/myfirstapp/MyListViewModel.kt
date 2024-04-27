package com.example.myfirstapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyListViewModel : ViewModel() {

    private val _feeds = MutableLiveData<MutableList<ModeList>>().apply {
        value?.add(ModeList(1, "Deven"))
    }
    val feeds: LiveData<MutableList<ModeList>> = _feeds
}