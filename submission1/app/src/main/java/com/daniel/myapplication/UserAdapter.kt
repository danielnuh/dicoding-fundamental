package com.daniel.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniel.myapplication.databinding.ItemviewBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private val listUser = ArrayList<User>()

    class ViewHolder(private val binding: ItemviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                username.text = user.username
                follower.text = "Follower " + user.follower
                following.text = "Follower " + user.following
                val resImage = root.context.getResources().getIdentifier(
                    user.avatar.split("/")[1],
                    "drawable",
                    root.context.getPackageName()
                )
                imageView.setImageResource(resImage)
            }
        }
    }

    fun setData(listUser: List<User>) {
        this.listUser.clear()
        this.listUser.addAll(listUser)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listUser[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailUserActivity::class.java)
            intent.putExtra("data", listUser[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listUser.size
}