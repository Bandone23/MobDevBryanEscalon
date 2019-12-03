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
    private val clickListener: (ArrayList<String>, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {
    private var mTextListener: ItemTextListener? = null

    private lateinit var callbacks: onClikViewModel
    fun onClickViewModel(callback: onClikViewModel) {
        callbacks = callback
    }


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
        holder.itemView.container_card.setOnClickListener {
             name= item
            callbacks.onClickViewModel()
        }

    }

    interface ItemTextListener {
        fun onDeleteItem(position : Int)
    }


    // allows clicks events to be caught
    internal fun setClickListener(itemTextListener: BreedsAdapter.ItemTextListener) {
        this.mTextListener = itemTextListener

    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

