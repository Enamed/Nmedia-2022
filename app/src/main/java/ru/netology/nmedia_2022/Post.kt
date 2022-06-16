package ru.netology.nmedia_2022

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var countShare: Int,
    var countLike: Int,
    var countVisio: Int


)
