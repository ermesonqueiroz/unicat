package com.github.ermesonqueiroz.unicat

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.ermesonqueiroz.unicat.domain.Post

class FeedAdapter(private val posts: List<Post>) : RecyclerView.Adapter<FeedAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvatar: View = view.findViewById(R.id.imgAvatar)
        val tvUsername: TextView = view.findViewById(R.id.tvUsername)
        val tvCaption: TextView = view.findViewById(R.id.tvCaption)
        val imgPost: ImageView = view.findViewById(R.id.imgPost)
        val tvLikesCount: TextView = view.findViewById(R.id.tvLikesCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        holder.tvUsername.text = post.username
        holder.tvCaption.text = post.caption
        holder.tvLikesCount.text = "${post.likesCount} curtidas"

        holder.imgAvatar.setBackgroundColor(Color.parseColor(post.avatarBgColor))
        holder.imgPost.setBackgroundColor(Color.parseColor(post.postBgColor))
    }

    override fun getItemCount(): Int = posts.size
}