package ru.netology.nmedia_2022

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia_2022.databinding.ActivityMainBinding
import ru.netology.nmedia_2022.utils.Utils


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
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
                    if (post.likedByMe) {
                        ++post.countLike
                        countLike.text = Utils.numbers(post.countLike)
                    } else {
                        --post.countLike
                        countLike.text = Utils.numbers(post.countLike)
                    }
                }

                share.setOnClickListener {
                    ++post.countShare
                    post.countShare = post.countShare
                    countShare.text = Utils.numbers(post.countShare)
                }


            }

        }
    }
}