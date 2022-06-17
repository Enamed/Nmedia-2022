package ru.netology.nmedia_2022.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia_2022.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
}