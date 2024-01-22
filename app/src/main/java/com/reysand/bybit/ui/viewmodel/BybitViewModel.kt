package com.reysand.bybit.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reysand.bybit.data.model.Announcement
import com.reysand.bybit.data.util.BybitService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BybitViewModel : ViewModel() {

    private var _announcementList = MutableStateFlow<List<Announcement>>(emptyList())
    val announcementList = _announcementList.asStateFlow()

    val bybitService = BybitService()

    init {
        viewModelScope.launch {
            _announcementList.value = bybitService.fetchData().result.list
            Log.d("BybitViewModel", "announcementList: ${_announcementList.value.size}")
        }
    }
}