package com.example.dogschallenge.repositories

import com.example.dogschallenge.services.CeoDogsApi

class CeoDogsRepository(private val api: CeoDogsApi) {
    suspend fun listBreeds(): Result<List<String>> {
        return try {
            val response = api.listBreeds()
            val breeds = response.message.keys.toList()
            Result.success(breeds)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }
}