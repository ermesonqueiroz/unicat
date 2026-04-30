package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AdminFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_feed)

        setupNavigation()
    }

    private fun setupNavigation() {
        findViewById<View>(R.id.navAdminHome).setOnClickListener {
            startActivity(Intent(this, AdminHomeActivity::class.java))
            finish()
        }

        findViewById<View>(R.id.navAdminGatos).setOnClickListener {
            startActivity(Intent(this, ListaGatosActivity::class.java))
        }

        findViewById<View>(R.id.navAdminUsuarios).setOnClickListener {
            // startActivity(Intent(this, UsuariosActivity::class.java))
        }

        findViewById<View>(R.id.navAdminFeed).setOnClickListener {
            // Already here
        }

        findViewById<View>(R.id.navAdminMapa).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }
}
