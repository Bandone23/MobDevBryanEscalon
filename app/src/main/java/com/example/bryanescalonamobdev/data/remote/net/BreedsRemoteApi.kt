package com.example.bryanescalonamobdev.data.remote.net

import com.example.bryanescalonamobdev.data.DataConstants.NAME_BREEDS
import com.example.bryanescalonamobdev.data.remote.model.BreedsEntry
import com.example.bryanescalonamobdev.data.remote.model.BreedsImgEntry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedsRemoteApi {
    @GET("breeds/list")
    fun getBreeds(): Call<BreedsEntry>

    @GET("breed/{nameId}/images/random")
    fun getBreedsImg(@Path(NAME_BREEDS) id: String): Call<BreedsImgEntry>
}