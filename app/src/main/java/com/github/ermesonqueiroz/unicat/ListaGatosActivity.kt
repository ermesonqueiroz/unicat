package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ListaGatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_gatos)
        NavigationUtils.setupBottomNavigation(this)

        // Navegar para Busca ao clicar no campo de busca
        findViewById<android.view.View>(R.id.etBusca).setOnClickListener {
            startActivity(android.content.Intent(this, BuscaActivity::class.java))
        }

        // Navegar para Perfil do Gato ao clicar nos itens da lista
        val itemMingau = findViewById<android.view.View>(R.id.itemMingau)
        val itemPretinha = findViewById<android.view.View>(R.id.itemPretinha)
        val itemTigrao = findViewById<android.view.View>(R.id.itemTigrao)

        val intentPerfilGato = android.content.Intent(this, PerfilGatoActivity::class.java)

        itemMingau?.setOnClickListener { startActivity(intentPerfilGato) }
        itemPretinha?.setOnClickListener { startActivity(intentPerfilGato) }
        itemTigrao?.setOnClickListener { startActivity(intentPerfilGato) }
    }
}
