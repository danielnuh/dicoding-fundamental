package com.daniel.myapplication

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserResponse(
    @SerializedName("users")
    val users: List<UserItem>
)

data class UserItem(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("follower")
    val follower: Int,
    @SerializedName("following")
    val following: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("repository")
    val repository: Int,
    @SerializedName("username")
    val username: String
)