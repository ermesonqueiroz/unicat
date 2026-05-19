package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)
        setupClickListeners()
        setupNavigation()
    }

    private fun setupClickListeners() {
        findViewById<Button>(R.id.btnCadastrarGato).setOnClickListener {
            Toast.makeText(this, "Cadastro de gato em breve", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnVerUsuarios).setOnClickListener {
            startActivity(Intent(this, GestaoUsuariosActivity::class.java))
        }
        findViewById<Button>(R.id.btnModerarFeed).setOnClickListener {
            startActivity(Intent(this, AdminFeedActivity::class.java))
        }
        findViewById<Button>(R.id.btnAtualizarMapa).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }

    private fun setupNavigation() {
        // navAdminHome → já está aqui
        findViewById<View>(R.id.navAdminHome)?.setOnClickListener { /* já estou aqui */ }

        findViewById<View>(R.id.navAdminGatos).setOnClickListener {
            startActivity(Intent(this, ListaGatosActivity::class.java))
        }
        findViewById<View>(R.id.navAdminUsuarios).setOnClickListener {
            startActivity(Intent(this, GestaoUsuariosActivity::class.java))
        }
        findViewById<View>(R.id.navAdminFeed).setOnClickListener {
            startActivity(Intent(this, AdminFeedActivity::class.java))
        }
        findViewById<View>(R.id.navAdminMapa).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }
}
