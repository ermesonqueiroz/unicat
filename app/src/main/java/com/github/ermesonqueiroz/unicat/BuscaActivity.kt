package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BuscaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)

        // Voltar
        findViewById<TextView>(R.id.btnVoltar).setOnClickListener { finish() }

        // Abas de filtro
        val tabTodos    = findViewById<TextView>(R.id.tabTodos)
        val tabGatos    = findViewById<TextView>(R.id.tabGatos)
        val tabUsuarios = findViewById<TextView>(R.id.tabUsuarios)

        tabTodos.setOnClickListener {
            tabTodos.setBackgroundColor(0xFF1A56A0.toInt()); tabTodos.setTextColor(0xFFFFFFFF.toInt())
            tabGatos.setBackgroundColor(0xFFFFFFFF.toInt()); tabGatos.setTextColor(0xFF6B7280.toInt())
            tabUsuarios.setBackgroundColor(0xFFFFFFFF.toInt()); tabUsuarios.setTextColor(0xFF6B7280.toInt())
        }
        tabGatos.setOnClickListener {
            tabGatos.setBackgroundColor(0xFF1A56A0.toInt()); tabGatos.setTextColor(0xFFFFFFFF.toInt())
            tabTodos.setBackgroundColor(0xFFFFFFFF.toInt()); tabTodos.setTextColor(0xFF6B7280.toInt())
            tabUsuarios.setBackgroundColor(0xFFFFFFFF.toInt()); tabUsuarios.setTextColor(0xFF6B7280.toInt())
        }
        tabUsuarios.setOnClickListener {
            tabUsuarios.setBackgroundColor(0xFF1A56A0.toInt()); tabUsuarios.setTextColor(0xFFFFFFFF.toInt())
            tabTodos.setBackgroundColor(0xFFFFFFFF.toInt()); tabTodos.setTextColor(0xFF6B7280.toInt())
            tabGatos.setBackgroundColor(0xFFFFFFFF.toInt()); tabGatos.setTextColor(0xFF6B7280.toInt())
        }

        // Resultados → PerfilGatoActivity
        val goToGato = Intent(this, PerfilGatoActivity::class.java)
        findViewById<android.view.View>(R.id.itemMingau).setOnClickListener   { startActivity(goToGato) }
        findViewById<android.view.View>(R.id.itemPretinha).setOnClickListener { startActivity(goToGato) }
        findViewById<android.view.View>(R.id.itemTigrao).setOnClickListener   { startActivity(goToGato) }

        // Bottom nav
        NavigationUtils.setupBottomNavigation(this)
    }
}
