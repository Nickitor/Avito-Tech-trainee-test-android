package com.nikitazamyslov.avito_tech_trainee_test_android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _data: MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val data get() = _data

    init {
        _data.update { _ ->
            (1..15).map { Item() }
        }
    }

    fun deleteItem(item: Item) {
        _data.update { list ->
            val newList = list.toMutableList()
            newList.remove(item)
            newList
        }
    }
}