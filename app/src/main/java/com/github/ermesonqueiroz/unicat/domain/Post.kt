package com.github.ermesonqueiroz.unicat.domain

data class Post(
    val username: String,
    val caption: String,
    val likesCount: Int,
    val avatarBgColor: String,
    val postBgColor: String
)
