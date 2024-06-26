package com.example.dogschallenge.services

import com.example.dogschallenge.models.CeoBreedsResponse
import com.example.dogschallenge.models.ImageResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CeoDogsApi {
    @GET("breeds/list/all")
    suspend fun listBreeds():CeoBreedsResponse
    @GET("breed/{breed}/images/random")
    suspend fun getRandomImageByBreed(
        @Path("breed") breed: String
    ):ImageResponse
}

object CeoDogsApiFactory {
    fun create(): CeoDogsApi {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CeoDogsApi::class.java)
    }
}