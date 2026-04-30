package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
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
            // TODO: Implementar cadastro de gato
        }

        findViewById<Button>(R.id.btnVerUsuarios).setOnClickListener {
            // TODO: Implementar visualização de usuários
        }

        findViewById<Button>(R.id.btnModerarFeed).setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }

        findViewById<Button>(R.id.btnAtualizarMapa).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }

    private fun setupNavigation() {
        findViewById<View>(R.id.navAdminGatos).setOnClickListener {
            startActivity(Intent(this, ListaGatosActivity::class.java))
        }

        findViewById<View>(R.id.navAdminUsuarios).setOnClickListener {
            // startActivity(Intent(this, UsuariosActivity::class.java))
        }

        findViewById<View>(R.id.navAdminFeed).setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }

        findViewById<View>(R.id.navAdminMapa).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }
}
