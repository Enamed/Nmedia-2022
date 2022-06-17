package ru.netology.nmedia_2022.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia_2022.Post

class PostRepositoryInMemoryImpl : PostRepository {
private var post = Post(
    id = 1,
    author = "Нетология. УНивер инет профессий будущего",
    content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
            "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы меняемся сами и помогаем меняться студентам: расти от новичков до уверенных профессионалов.  " +
            "Но самое важное остаётся — наша вера в то, что в каждом заложена сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. " +
            "А наша миссия — помочь выбрать путь и начать цепочку перемен → http://netolo.gy/fyb",
    published = "15 июня 2022 в 18:11",
    likedByMe = false,
    countShare = 999,
    countLike = 999,
    countVisio = 1_000
)
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like(){
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
}