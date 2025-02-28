package com.kishan.githubreposapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kishan.githubreposapp.R
import com.kishan.githubreposapp.model.Repository

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private val repos = mutableListOf<Repository>()

    fun setItems(items: List<Repository>) {
        //repos.clear()
        repos.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repos[position]
        holder.bind(repo)
    }

    override fun getItemCount() = repos.size

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(repo: Repository) {
            itemView.findViewById<TextView>(R.id.tvRepoName).text = repo.name
            itemView.findViewById<TextView>(R.id.tvDescription).text = repo.description ?: "No description"
            itemView.findViewById<TextView>(R.id.tvLanguage).text = repo.language ?: "Unknown"
            itemView.findViewById<TextView>(R.id.tvStars).text = "Stars: ${repo.stargazers_count}"
            itemView.findViewById<TextView>(R.id.tvForks).text = "Forks: ${repo.forks_count}"
        }
    }
}
