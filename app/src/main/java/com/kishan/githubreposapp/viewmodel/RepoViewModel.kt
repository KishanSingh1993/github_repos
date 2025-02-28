package com.kishan.githubreposapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishan.githubreposapp.model.Repository
import com.kishan.githubreposapp.repository.RepoRepository
import com.kishan.githubreposapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor(private val repository: RepoRepository) : ViewModel() {

    private val _repos = MutableLiveData<Resource<List<Repository>>>()
    val repos: LiveData<Resource<List<Repository>>> = _repos

    private var currentPage = 1
    private var isLastPage = false
    private val allRepositories = mutableListOf<Repository>()

    fun fetchRepositories(username: String) {
        if (isLastPage) return
        viewModelScope.launch {
            _repos.value = Resource.Loading()
            val result = repository.fetchRepositories(username, currentPage)
            when (result) {
                is Resource.Success<*> -> {
                    if (result.data?.isEmpty() == true) {
                        isLastPage = true
                    } else {
                        result.data?.let { allRepositories.addAll(it) }
                        _repos.value = Resource.Success(allRepositories)
                        currentPage++
                    }
                }
                is Resource.Error<*> -> {
                    _repos.value = result
                }

                is Resource.Loading -> TODO()
            }
        }
    }
}
