package com.example.bryanescalonamobdev.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bryanescalonamobdev.R
import com.example.bryanescalonamobdev.databinding.ItemBreedsBinding
import com.example.bryanescalonamobdev.ui.adapter.holder.BreedsNHolder
import com.example.bryanescalonamobdev.ui.interfaces.onClikViewModel
import kotlinx.android.synthetic.main.item_breeds.view.*

 var name =""
class BreedsAdapter(
    private var items: ArrayList<String>,
    private val clickListener: (String, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding:ItemBreedsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_breeds,parent,false
            )
        return BreedsNHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
     val item = items[position]
        holder as BreedsNHolder
        holder.bindEvent(item,clickListener)


    }


}

