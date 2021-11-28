package com.daniel.myapplication

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RawRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userAdapter = UserAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromJson()


        with(binding.rvUser) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = userAdapter
        }
    }

    private fun getDataFromJson() {
        val json = resources.getRawTextFile(R.raw.githubuser)
        val userResponse = Gson().fromJson(json, UserResponse::class.java)

        val listData = ArrayList<User>()

        for (item in userResponse.users) {
            with(item) {
                listData.add(
                    User(
                        username,
                        name,
                        avatar,
                        company,
                        location,
                        repository,
                        follower,
                        following
                    )
                )
            }
        }
        userAdapter.setData(listData)
    }

    private fun Resources.getRawTextFile(@RawRes id: Int) =
        openRawResource(id).bufferedReader().use { it.readText() }
}