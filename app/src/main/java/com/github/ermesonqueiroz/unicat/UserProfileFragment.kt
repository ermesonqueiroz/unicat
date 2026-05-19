package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class UserProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<android.widget.TextView>(R.id.btnNotificacoes)?.setOnClickListener {
            startActivity(Intent(requireActivity(), NotificacoesActivity::class.java))
        }

        view.findViewById<android.widget.TextView>(R.id.btnEditar)?.setOnClickListener {
            Toast.makeText(requireActivity(), "Editar perfil em breve", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<android.widget.TextView>(R.id.btnSair)?.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        setupPostDeletion(view)
    }

    private fun setupPostDeletion(view: View) {
        val postIds = listOf(R.id.post1, R.id.post2, R.id.post3, R.id.post4)
        postIds.forEach { id ->
            view.findViewById<View>(id)?.setOnLongClickListener {
                androidx.appcompat.app.AlertDialog.Builder(requireActivity())
                    .setTitle(R.string.confirm_delete_post_title)
                    .setMessage(R.string.confirm_delete_post_message)
                    .setPositiveButton(R.string.confirm_yes) { _, _ ->
                        it.visibility = View.GONE
                        Toast.makeText(requireActivity(), "Post excluído", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton(R.string.confirm_no, null)
                    .show()
                true
            }
        }
    }
}