package com.example.bryanescalonamobdev.domain.usecase

import com.example.bryanescalonamobdev.data.repository.BreedsRepository
import com.example.bryanescalonamobdev.domain.model.Breeds
import com.example.core.coroutines.ResultUnitUseCase
import kotlinx.coroutines.Dispatchers

class GetBreedsUseCase(
    private val repository: BreedsRepository
) : ResultUnitUseCase<Breeds>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): Breeds? {
        return repository.getBreeds()
    }

}
