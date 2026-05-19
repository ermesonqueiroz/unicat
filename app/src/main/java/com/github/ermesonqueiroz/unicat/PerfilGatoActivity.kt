package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class PerfilGatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_gato)

        // Toolbar — voltar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setNavigationOnClickListener { finish() }

        // Botão Apadrinhar
        findViewById<android.widget.Button>(R.id.btnSponsor)?.setOnClickListener {
            Toast.makeText(this, "Solicitação de apadrinhamento enviada!", Toast.LENGTH_SHORT).show()
        }
    }
}
