package com.kishan.githubreposapp.repository

import com.kishan.githubreposapp.model.Repository
import com.kishan.githubreposapp.network.ApiService
import com.kishan.githubreposapp.util.Resource
import javax.inject.Inject

class RepoRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchRepositories(username: String, page: Int): Resource<List<Repository>> {
        return try {
            val response = apiService.getRepositories(username, page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An error occurred")
        }
    }
}
