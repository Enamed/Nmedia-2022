package ru.netology.nmedia_2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia_2022.databinding.ActivityMainBinding
import ru.netology.nmedia_2022.utils.Utils


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val post = Post(
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

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            countShare.text = Utils.numbers(post.countShare)
            countLike.text = Utils.numbers(post.countLike)
            countVisio.text = Utils.numbers(post.countVisio)

            if (post.likedByMe)
                like.setImageResource(R.drawable.ic_baseline_favorite_red)

            like.setOnClickListener {
                post.likedByMe = !post.likedByMe
                post.countLike = post.countLike
                like.setImageResource(
                    if (post.likedByMe)
                        R.drawable.ic_baseline_favorite_red
                    else R.drawable.ic_baseline_favorite_border_24
                )
                if (post.likedByMe){
                    ++post.countLike
                    countLike.text = Utils.numbers(post.countLike)}
                else{
                    --post.countLike
                    countLike.text = Utils.numbers(post.countLike)}
            }

            share.setOnClickListener {
                ++post.countShare
                post.countShare = post.countShare
                countShare.text = Utils.numbers(post.countShare)
            }


        }


    }
}