package com.daniel.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daniel.myapplication.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<User>("data")

        with(binding){
            if (data != null){
                val resImage = root.context.getResources().getIdentifier(
                    data.avatar.split("/")[1],
                    "drawable",
                    root.context.getPackageName()
                )
                image.setImageResource(resImage)
                name.text = data.name
                username.text = data.username
                follower.text = "Follower "+data.follower
                following.text = "Following "+data.following
                repository.text = "Repository "+data.repository
                company.text = data.company
                location.text = data.location
            }
        }
    }
}