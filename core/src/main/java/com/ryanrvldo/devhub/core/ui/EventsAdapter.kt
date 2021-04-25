package com.ryanrvldo.devhub.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryanrvldo.devhub.core.databinding.ItemEventBinding
import com.ryanrvldo.devhub.core.domain.model.events.Event
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents

class EventsAdapter :
    PagingDataAdapter<ReceivedEvents, EventsAdapter.EventsViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        return EventsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ReceivedEvents>() {
            override fun areItemsTheSame(
                oldItem: ReceivedEvents,
                newItem: ReceivedEvents,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ReceivedEvents,
                newItem: ReceivedEvents,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class EventsViewHolder(
        private val binding: ItemEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ReceivedEvents) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(item.actor.avatarUrl)
                    .into(imgAvatar)
                tvActorUsername.text = item.actor.username
                val event = Event.values().firstOrNull { item.type == it.type }?.event
                if (event != null) {
                    tvEvent.text = event
                } else {
                    tvEvent.text = item.type
                }
                repoCard.tvRepoName.text = item.repo.name
                if (item.payload.description != "null") {
                    repoCard.tvRepoDesc.text = item.payload.description
                } else {
                    repoCard.tvRepoDesc.visibility = View.GONE
                }
                repoCard.tvRepoUpdateTime.text = item.createdAt
            }
        }

        companion object {
            fun create(parent: ViewGroup): EventsViewHolder = EventsViewHolder(
                ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

}
