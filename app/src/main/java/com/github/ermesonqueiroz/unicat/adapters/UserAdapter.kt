package com.github.ermesonqueiroz.unicat.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.ermesonqueiroz.unicat.R
import com.github.ermesonqueiroz.unicat.User

class UserAdapter(
    private val context: Context,
    private val users: MutableList<User>
) : BaseAdapter() {

    override fun getCount(): Int = users.size
    override fun getItem(position: Int): User = users[position]
    override fun getItemId(position: Int): Long = users[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        bindUser(holder, users[position], position)
        return view
    }

    private fun bindUser(holder: ViewHolder, user: User, position: Int) {
        holder.tvName.text = user.name

        val affiliateLabel = if (user.affiliatesCount == 1) "1 afiliado" else "${user.affiliatesCount} afiliados"

        if (user.isActive) {
            holder.tvStatus.text = context.getString(R.string.status_active)
            holder.tvStatus.setTextColor(context.resources.getColor(R.color.status_active, null))
            holder.viewStatusDot.setBackgroundResource(R.drawable.bg_dot_active)
            holder.btnToggleStatus.text = context.getString(R.string.btn_deactivate)
            holder.btnToggleStatus.setBackgroundResource(R.drawable.bg_btn_yellow)
        } else {
            holder.tvStatus.text = context.getString(R.string.status_inactive)
            holder.tvStatus.setTextColor(context.resources.getColor(R.color.status_inactive, null))
            holder.viewStatusDot.setBackgroundResource(R.drawable.bg_dot_inactive)
            holder.btnToggleStatus.text = context.getString(R.string.btn_activate)
            holder.btnToggleStatus.setBackgroundResource(R.drawable.bg_btn_green)
        }

        holder.tvAffiliates.text = affiliateLabel

        holder.btnToggleStatus.setOnClickListener {
            user.isActive = !user.isActive
            notifyDataSetChanged()
            val msg = if (user.isActive) "Usuário ativado" else "Usuário desativado"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        holder.btnDelete.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle(R.string.confirm_delete_title)
                .setMessage(R.string.confirm_delete_message)
                .setPositiveButton(R.string.confirm_yes) { _, _ ->
                    users.removeAt(position)
                    notifyDataSetChanged()
                    Toast.makeText(context, "Usuário excluído", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(R.string.confirm_no, null)
                .show()
        }
    }

    inner class ViewHolder(view: View) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvStatus: TextView = view.findViewById(R.id.tvStatus)
        val tvAffiliates: TextView = view.findViewById(R.id.tvAffiliates)
        val viewStatusDot: View = view.findViewById(R.id.viewStatusDot)
        val btnToggleStatus: Button = view.findViewById(R.id.btnToggleStatus)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }
}