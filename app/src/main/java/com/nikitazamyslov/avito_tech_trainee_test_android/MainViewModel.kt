package com.nikitazamyslov.avito_tech_trainee_test_android

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel : ViewModel() {

    private var _data: MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val data get() = _data

    private val itemDeletedPool: Queue<Item> = LinkedList()

    init {
        _data.update { _ ->
            (1..15).map { Item() }
        }
        start()
    }

    fun deleteItem(item: Item) {
        _data.update { list ->
            list.toMutableList().apply {
                itemDeletedPool.add(item)
                remove(item)
            }
        }
    }

    private fun addRandomItem() {
        _data.update { list ->
            val item = itemDeletedPool.poll() ?: Item()
            list.toMutableList().apply { add((0..size).random(), item) }
        }
    }

    private fun start() {
        viewModelScope.launch {
            while (true) {
                addRandomItem()
                delay(5000)
            }
        }
    }
}