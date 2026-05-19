package com.github.ermesonqueiroz.unicat

data class User(
    val id: Int,
    val name: String,
    var isActive: Boolean,
    val affiliatesCount: Int
)
