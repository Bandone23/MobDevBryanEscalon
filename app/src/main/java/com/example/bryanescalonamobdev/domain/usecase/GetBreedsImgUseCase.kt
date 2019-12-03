package com.example.bryanescalonamobdev.domain.usecase

import com.example.bryanescalonamobdev.data.repository.BreedsRepository
import com.example.bryanescalonamobdev.domain.model.BreedsImg
import com.example.bryanescalonamobdev.domain.model.request.NameDogRequest
import com.example.core.coroutines.ResultUseCase
import kotlinx.coroutines.Dispatchers

class GetBreedsImgUseCase (
    private val repository: BreedsRepository
) : ResultUseCase<NameDogRequest,BreedsImg>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: NameDogRequest): BreedsImg? {
        return repository.getBreedsImg(nameId = params.nameId)
    }


}
