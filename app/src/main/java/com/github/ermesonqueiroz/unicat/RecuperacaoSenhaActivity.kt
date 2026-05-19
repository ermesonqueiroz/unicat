package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class RecuperacaoSenhaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacao_senha)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val btnEnviarLink = findViewById<Button>(R.id.btnEnviarLink)
        btnEnviarLink.setOnClickListener {
            Toast.makeText(this, "Link de recuperação enviado!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}