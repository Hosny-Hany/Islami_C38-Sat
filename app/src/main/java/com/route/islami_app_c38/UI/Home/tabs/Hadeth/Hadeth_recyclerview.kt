package com.route.islami_app_c38.UI.Home.tabs.Hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_app_c38.UI.Home.Model.Hadeth
import com.route.islami_app_c38.databinding.ItemHadethBinding

class Hadeth_recyclerview(private var items: List<Hadeth>?): RecyclerView.Adapter<Hadeth_recyclerview.ViewHolder>() {
    lateinit var viewBinding: ItemHadethBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text= items!![position].title.toString()
        if (onItemClickListner!=null) holder.viewBinding.root
            .setOnClickListener {
                onItemClickListner?.onItemClick(position,items!![position])
            }
    }

    override fun getItemCount(): Int =items?.size?:0
    fun bindHadethItem(newList: List<Hadeth>?){
        items = newList
        notifyDataSetChanged()
    }
    //fun insertitem(hadeth: Hadeth){
      // items.add(hadeth.toString())
        //notifyItemInserted(items?.size-1)
    //}

    var onItemClickListner : onItemClickListners?=null

    fun interface onItemClickListners{
         fun onItemClick(position: Int, item: Hadeth)
    }


    class ViewHolder (val viewBinding:ItemHadethBinding)
        : RecyclerView.ViewHolder(viewBinding.root)
}