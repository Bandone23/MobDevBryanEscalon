package com.example.bryanescalonamobdev.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.example.bryanescalonamobdev.URL_BASE_API
import com.example.bryanescalonamobdev.data.remote.net.BreedsRemoteApi
import com.example.bryanescalonamobdev.data.remote.source.BreedsRemoteDataSource
import com.example.bryanescalonamobdev.data.repository.BreedsRepository
import com.example.bryanescalonamobdev.domain.usecase.GetBreedsImgUseCase
import com.example.bryanescalonamobdev.domain.usecase.GetBreedsUseCase
import com.example.bryanescalonamobdev.presentation.viewmodel.BreedsViewModel
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {


    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(BreedsRemoteApi::class.java) as BreedsRemoteApi }


    /* DataSource */
    factory { BreedsRemoteDataSource(get()) }
    // factory { MatchesRemoteDataSource(get()) }
    /* Repositories */
    factory { BreedsRepository(get()) }
    // factory { MatchesRepository(get()) }
    /* View models */
    viewModel { BreedsViewModel(get(),get()) }
    //  viewModel { MatchesViewModel(get()) }
    /* UseCases */
    factory { GetBreedsUseCase(get()) }
      factory { GetBreedsImgUseCase(get()) }

    /* Picasso */
    single {
        Picasso.get()
    }

}