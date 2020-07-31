package com.example.bryanescalonamobdev.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.bryanescalonamobdev.R
import com.example.bryanescalonamobdev.databinding.ItemBreedsBinding
import com.example.bryanescalonamobdev.domain.model.Breeds

class BreedsNHolder (
    private val binding: ItemBreedsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(breedsData: String,
                  clickListener: (String, Int) -> Unit
                  ) {
        binding.textBreeds.text = breedsData
        binding.name =breedsData
        binding.containerCard.setOnClickListener {  clickListener(breedsData, binding.containerCard.id) }
        binding.executePendingBindings()
    }

}