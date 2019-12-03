package com.example.bryanescalonamobdev.data.remote.model

import com.example.bryanescalonamobdev.domain.model.Breeds

data class BreedsEntry (
    val message:List<String>,
    val status :String

)
fun BreedsEntry.toBreeds()= Breeds (
    message=message,
    status = status
)