package com.route.islami_app_c38.UI.Home.tabs.Quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_app_c38.databinding.ChapterNameBinding

class recyclerviewAdapter_Quran(private val names: Array<String>):RecyclerView.Adapter<recyclerviewAdapter_Quran.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val viewBinding =ChapterNameBinding.inflate(LayoutInflater.from(parent.context)
         ,parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.viewBinding.title.text=names[position]
        if (onItemClickListner!=null) holder.viewBinding.root
            .setOnClickListener {
                onItemClickListner?.onItemClick(position,names[position])
            }
    }

    override fun getItemCount(): Int =names.size

    var onItemClickListner : onItemClickListners?=null

    fun interface onItemClickListners{
        fun onItemClick(position: Int,name: String)
    }

    class ViewHolder (val viewBinding: ChapterNameBinding )
        :RecyclerView.ViewHolder(viewBinding.root)
}