package com.alim.coroutinewithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alim.coroutinewithretrofit.model.PostResponseDto
import javax.inject.Inject

class PostsAdapter @Inject constructor() : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    var posts: List<PostResponseDto> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        posts[position].let {
            holder.title.text = it.title
            holder.description.text = it.body
        }
    }

    class ViewHolder(baseView: View) : RecyclerView.ViewHolder(baseView) {
        val title = baseView.findViewById<TextView>(R.id.title)
        val description = baseView.findViewById<TextView>(R.id.description)
    }
}