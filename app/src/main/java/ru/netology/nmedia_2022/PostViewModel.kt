package ru.netology.nmedia_2022

import androidx.lifecycle.ViewModel
import ru.netology.nmedia_2022.repository.PostRepository
import ru.netology.nmedia_2022.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()

}