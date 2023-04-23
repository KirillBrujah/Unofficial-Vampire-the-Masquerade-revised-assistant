package com.cainites.unofficialvtmrevisedassistant.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info.GameCharacterInfo
import com.cainites.unofficialvtmrevisedassistant.databinding.GameCharactersListItemBinding

class GameCharactersListAdapter :
    ListAdapter<GameCharacterInfo, GameCharactersListAdapter.GameCharacterViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<GameCharacterInfo>() {
            override fun areItemsTheSame(
                oldItem: GameCharacterInfo,
                newItem: GameCharacterInfo
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: GameCharacterInfo,
                newItem: GameCharacterInfo
            ): Boolean = oldItem.id == newItem.id

        }
    }


    class GameCharacterViewHolder(private var binding: GameCharactersListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gameCharacterInfo: GameCharacterInfo) {
            binding.gameCharacterInfo = gameCharacterInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCharacterViewHolder {
        val viewHolder = GameCharacterViewHolder(
            GameCharactersListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            // TODO: Navigate to List
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: GameCharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}