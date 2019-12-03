package com.example.bryanescalonamobdev.data.remote.model

import com.example.bryanescalonamobdev.domain.model.BreedsImg

data class BreedsImgEntry (
    val message :String,
    val status:String

)
fun BreedsImgEntry.toBreedsImg()= BreedsImg (
    message= message,
    status=status
)