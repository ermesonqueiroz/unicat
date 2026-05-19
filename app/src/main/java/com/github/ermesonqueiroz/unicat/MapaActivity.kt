package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mapa)
        NavigationUtils.setupBottomNavigation(this)

        // btnVerGatos → ListaGatosActivity
//        findViewById<android.widget.Button>(R.id.btnVerGatos)?.setOnClickListener {
//            startActivity(Intent(this, ListaGatosActivity::class.java))
//        }
    }
}
