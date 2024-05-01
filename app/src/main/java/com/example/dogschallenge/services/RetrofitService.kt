package com.example.dogschallenge.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("breeds/list/all")
    suspend fun listBreeds()
    @GET("breed/{breed}/images/random")
    suspend fun getRandomImageByBreed(
        @Path("breed") breed: String
    )
}

object RetrofitServiceFactory {
    fun create(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }
}