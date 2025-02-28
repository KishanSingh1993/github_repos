package com.kishan.githubreposapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kishan.githubreposapp.R
import com.kishan.githubreposapp.util.PaginationScrollListener
import com.kishan.githubreposapp.util.Resource
import com.kishan.githubreposapp.util.VerticalSpaceItemDecoration
import com.kishan.githubreposapp.viewmodel.RepoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoListFragment : Fragment(R.layout.fragment_repo_list) {

    private val viewModel: RepoViewModel by viewModels()
    private lateinit var adapter: RepoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val errorTextView = view.findViewById<TextView>(R.id.tvMessage)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = RepoAdapter()
        recyclerView.adapter = adapter


        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.item_spacing)
        recyclerView.addItemDecoration(VerticalSpaceItemDecoration(spacingInPixels))

        val username = "philipplackner"  // Hardcoded or from arguments
        viewModel.fetchRepositories(username)

        viewModel.repos.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> progressBar.visibility = View.VISIBLE
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    adapter.setItems(resource.data ?: emptyList())
                    Log.d("List Size", resource.data?.size.toString())
                }
                is Resource.Error -> {
                    progressBar.visibility = View.GONE
                    errorTextView.visibility = View.VISIBLE
                    errorTextView.text = resource.message
                }
            }
        }

        recyclerView.addOnScrollListener(object : PaginationScrollListener() {
            override fun loadMoreItems() {
                viewModel.fetchRepositories(username)
            }

            override fun isLastPage() = false
            override fun isLoading() = progressBar.visibility == View.VISIBLE
        })
    }
}
