package com.nikitazamyslov.avito_tech_trainee_test_android

data class Item(
    var id: Int = UNDEFINED_ID,
    var isDeleted: Boolean = false,
) {
    init {
        id = ++ID
    }

    companion object {
        const val UNDEFINED_ID = -1
        var ID = 0
    }
}