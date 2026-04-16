package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val tvEsqueceuSenha = findViewById<TextView>(R.id.tvEsqueceuSenha)
        val tvCriarConta = findViewById<TextView>(R.id.tvCriarConta)

        btnEntrar.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val senha = etSenha.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Informe seu e-mail"
                return@setOnClickListener
            }

            if (senha.isEmpty()) {
                etSenha.error = "Informe sua senha"
                return@setOnClickListener
            }

            if (email == "gatos@unifor.br" && senha == "123456") {
                startActivity(Intent(this, PerfilGatoActivity::class.java))
            } else {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

        tvEsqueceuSenha.setOnClickListener {
            startActivity(Intent(this, RecuperacaoSenhaActivity::class.java))
        }

        tvCriarConta.setOnClickListener {
            startActivity(Intent(this, CriarContaActivity::class.java))
        }
    }
}
