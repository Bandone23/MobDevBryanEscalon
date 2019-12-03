package com.example.bryanescalonamobdev.data.repository

import com.example.bryanescalonamobdev.data.remote.model.toBreeds
import com.example.bryanescalonamobdev.data.remote.model.toBreedsImg
import com.example.bryanescalonamobdev.data.remote.source.BreedsRemoteDataSource
import com.example.bryanescalonamobdev.domain.model.Breeds
import com.example.bryanescalonamobdev.domain.model.BreedsImg

class BreedsRepository (
    private val breedsRemoteDataSource: BreedsRemoteDataSource
) {
    //TODO call remote

    suspend fun getBreeds(): Breeds {
        return breedsRemoteDataSource.getBreeds().toBreeds()
    }

    suspend fun getBreedsImg(nameId:String):BreedsImg {
        return  breedsRemoteDataSource.getBreedsImg(nameId).toBreedsImg()
    }
}