package com.example.bryanescalonamobdev.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bryanescalonamobdev.domain.model.Breeds
import com.example.bryanescalonamobdev.domain.model.BreedsImg
import com.example.bryanescalonamobdev.domain.model.request.NameDogRequest
import com.example.bryanescalonamobdev.domain.usecase.GetBreedsImgUseCase
import com.example.bryanescalonamobdev.domain.usecase.GetBreedsUseCase
import com.example.bryanescalonamobdev.ui.adapter.BreedsAdapter
import com.example.core.extension.LiveResult

class BreedsViewModel (
    private val getBreedsUseCase: GetBreedsUseCase,
    private val getBreedsImgUseCase: GetBreedsImgUseCase
) : ViewModel() {
    lateinit var adapter: BreedsAdapter
    val breedsLiveData = LiveResult<Breeds>()
    val breedsImgLiveData = LiveResult<BreedsImg>()


    fun getBreeds(){
        getBreedsUseCase.execute(liveData = breedsLiveData)
    }

    fun getBreedsImg(nameId: String){
        getBreedsImgUseCase.execute(liveData = breedsImgLiveData,params = NameDogRequest(nameId) )
    }

    fun initAdapter(clickListener: (String, Int) -> Unit) {
        adapter = BreedsAdapter(arrayListOf(), clickListener)

    }



    /*fun updateBreeds(breeds: List<String>) {
       adapter.setData(breeds)
        adapter.notifyDataSetChanged()
    }*/

}