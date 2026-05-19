package com.github.ermesonqueiroz.unicat.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.ermesonqueiroz.unicat.R
import com.github.ermesonqueiroz.unicat.domain.Cat

class CatAdapter(
    private val cats: List<Cat>,
    private val onItemClick: (Cat) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCatAvatar: View = view.findViewById(R.id.imgCatAvatar)
        val tvCatName: TextView = view.findViewById(R.id.tvCatName)
        val tvCatLocation: TextView = view.findViewById(R.id.tvCatLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]

        holder.tvCatName.text = cat.name
        holder.tvCatLocation.text = cat.location

        if (holder.imgCatAvatar is TextView) {
            holder.imgCatAvatar.text = cat.emoji
        }
        holder.imgCatAvatar.setBackgroundColor(Color.parseColor(cat.avatarBgColor))

        holder.itemView.setOnClickListener { onItemClick(cat) }
    }

    override fun getItemCount(): Int = cats.size
}
