package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PerfilPessoaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_pessoa)
        NavigationUtils.setupBottomNavigation(this)

        findViewById<android.widget.TextView>(R.id.btnNotificacoes).setOnClickListener {
            startActivity(Intent(this, NotificacoesActivity::class.java))
        }
    }
}
