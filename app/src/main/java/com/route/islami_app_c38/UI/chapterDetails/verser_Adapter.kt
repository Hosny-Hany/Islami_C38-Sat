package com.route.islami_app_c38.UI.chapterDetails

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_app_c38.databinding.ActivityContentDetailsBinding
import com.route.islami_app_c38.databinding.ItemVerseBinding

class verser_Adapter (val verses : List<String>): RecyclerView.Adapter<verser_Adapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemVerseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.content1.text = verses[position]

        }

        override fun getItemCount(): Int = verses.size


        class ViewHolder(val binding: ItemVerseBinding) :
            RecyclerView.ViewHolder(binding.root)
    }