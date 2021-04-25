package com.ryanrvldo.devhub.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryanrvldo.devhub.core.databinding.ItemUserBinding
import com.ryanrvldo.devhub.core.domain.model.search.User

class UsersAdapter : PagingDataAdapter<User, UsersAdapter.UserLinearViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserLinearViewHolder {
        return UserLinearViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserLinearViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }

    class UserLinearViewHolder(
        private val binding: ItemUserBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            Glide.with(itemView.context)
                .load(user.avatarUrl)
                .into(binding.imgAvatar)
            binding.tvUsername.text = user.username
        }

        companion object {
            fun create(parent: ViewGroup): UserLinearViewHolder = UserLinearViewHolder(
                ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}
