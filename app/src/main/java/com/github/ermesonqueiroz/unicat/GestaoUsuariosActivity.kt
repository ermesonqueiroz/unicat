package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.github.ermesonqueiroz.unicat.adapters.UserAdapter

/**
 * Tela de Gestão de Usuários (admin).
 * Acessada via AdminHomeActivity → btnVerUsuarios ou navAdminUsuarios.
 */
class GestaoUsuariosActivity : AppCompatActivity() {

    private lateinit var listViewUsers: ListView
    private lateinit var etSearch: EditText
    private lateinit var adapter: UserAdapter

    private val allUsers = mutableListOf(
        User(1, "Ana Souza",    isActive = true,  affiliatesCount = 2),
        User(2, "Lucas Alves",  isActive = true,  affiliatesCount = 1),
        User(3, "Marina Costa", isActive = false, affiliatesCount = 0),
        User(4, "Juliana Melo", isActive = true,  affiliatesCount = 3)
    )

    private val displayedUsers = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestao_usuarios)

        listViewUsers = findViewById(R.id.listViewUsers)
        etSearch = findViewById(R.id.etSearch)

        displayedUsers.addAll(allUsers)
        adapter = UserAdapter(this, displayedUsers)
        listViewUsers.adapter = adapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterUsers(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        setupBottomNav()
    }

    private fun filterUsers(query: String) {
        displayedUsers.clear()
        if (query.isEmpty()) {
            displayedUsers.addAll(allUsers)
        } else {
            val lower = query.lowercase()
            allUsers.filterTo(displayedUsers) { it.name.lowercase().contains(lower) }
        }
        adapter.notifyDataSetChanged()
    }

    private fun setupBottomNav() {
        // Home → AdminHomeActivity
        findViewById<android.view.View>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, AdminHomeActivity::class.java))
            finish()
        }
        // Gastos → placeholder (tela futura)
        findViewById<android.view.View>(R.id.navGastos).setOnClickListener {
            android.widget.Toast.makeText(this, "Módulo Gastos em breve", android.widget.Toast.LENGTH_SHORT).show()
        }
        // Usuários → já está aqui
        findViewById<android.view.View>(R.id.navUsuarios).setOnClickListener { /* já estou aqui */ }
        // Feed → AdminFeedActivity
        findViewById<android.view.View>(R.id.navFeed).setOnClickListener {
            startActivity(Intent(this, AdminFeedActivity::class.java))
        }
        // Mapas → MapaActivity
        findViewById<android.view.View>(R.id.navMapas).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }
}
