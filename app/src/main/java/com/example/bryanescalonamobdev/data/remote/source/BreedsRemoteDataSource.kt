package com.example.bryanescalonamobdev.data.remote.source

import com.example.bryanescalonamobdev.data.remote.model.BreedsEntry
import com.example.bryanescalonamobdev.data.remote.model.BreedsImgEntry
import com.example.bryanescalonamobdev.data.remote.net.BreedsRemoteApi
import com.example.core.extension.await

class BreedsRemoteDataSource (
    private val remoteApi: BreedsRemoteApi
) {

    suspend fun getBreeds(): BreedsEntry {
        return remoteApi.getBreeds().await()!!
    }
    suspend fun getBreedsImg(nameId:String): BreedsImgEntry {
        return  remoteApi.getBreedsImg(nameId).await()!!
    }
}