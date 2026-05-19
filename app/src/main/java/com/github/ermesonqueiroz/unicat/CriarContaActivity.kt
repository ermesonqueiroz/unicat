package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CriarContaActivity : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText
    private lateinit var etConfirmarSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)
        initViews()
    }

    private fun initViews() {
        etNome           = findViewById(R.id.etNome)
        etEmail          = findViewById(R.id.etEmail)
        etSenha          = findViewById(R.id.etSenha)
        etConfirmarSenha = findViewById(R.id.etConfirmarSenha)

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val tvLogin      = findViewById<TextView>(R.id.tvLogin)

        btnCadastrar.setOnClickListener { validarECadastrar() }

        // Voltar para login
        tvLogin.setOnClickListener { finish() }
    }

    private fun validarECadastrar() {
        val nome           = etNome.text.toString().trim()
        val email          = etEmail.text.toString().trim()
        val senha          = etSenha.text.toString().trim()
        val confirmarSenha = etConfirmarSenha.text.toString().trim()

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            Toast.makeText(this, getString(R.string.erro_campos_vazios), Toast.LENGTH_SHORT).show()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = getString(R.string.erro_email_invalido); etEmail.requestFocus(); return
        }
        
        val passwordPattern = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$".toRegex()
        if (!passwordPattern.matches(senha)) {
            etSenha.error = getString(R.string.erro_senha_fraca); etSenha.requestFocus(); return
        }

        if (senha != confirmarSenha) {
            etConfirmarSenha.error = getString(R.string.erro_senhas_diferentes)
            etConfirmarSenha.requestFocus(); return
        }

        Toast.makeText(this, getString(R.string.sucesso_cadastro, nome), Toast.LENGTH_LONG).show()

        // Após cadastro → volta para login
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        })
        finish()
    }
}
