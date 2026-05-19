package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotificacoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacoes)
        NavigationUtils.setupBottomNavigation(this)

        // Abas — apenas alternam visual (sem tela separada)
        val tabTodas   = findViewById<TextView>(R.id.tabTodas)
        val tabNaoLidas = findViewById<TextView>(R.id.tabNaoLidas)

        tabTodas?.setOnClickListener {
            tabTodas.setTextColor(resources.getColor(R.color.primary, null))
            tabNaoLidas?.setTextColor(resources.getColor(R.color.text_secondary, null))
        }
        tabNaoLidas?.setOnClickListener {
            tabNaoLidas.setTextColor(resources.getColor(R.color.primary, null))
            tabTodas?.setTextColor(resources.getColor(R.color.text_secondary, null))
        }
    }
}
