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
        etNome = findViewById(R.id.etNome)
        etEmail = findViewById(R.id.etEmail)
        etSenha = findViewById(R.id.etSenha)
        etConfirmarSenha = findViewById(R.id.etConfirmarSenha)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        btnCadastrar.setOnClickListener { validarECadastrar() }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }
    }

    private fun validarECadastrar() {
        val nome = etNome.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val senha = etSenha.text.toString().trim()
        val confirmarSenha = etConfirmarSenha.text.toString().trim()

        // 1. Verificar campos vazios
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            mostrarErro(getString(R.string.erro_campos_vazios))
            return
        }

        // 2. Validar formato de e-mail
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = getString(R.string.erro_email_invalido)
            etEmail.requestFocus()
            return
        }

        // 3. Validar tamanho da senha
        if (senha.length < 8) {
            etSenha.error = getString(R.string.erro_senha_curta)
            etSenha.requestFocus()
            return
        }

        // 4. Verificar se as senhas coincidem
        if (senha != confirmarSenha) {
            etConfirmarSenha.error = getString(R.string.erro_senhas_diferentes)
            etConfirmarSenha.requestFocus()
            return
        }

        // Sucesso
        val mensagemSucesso = getString(R.string.sucesso_cadastro, nome)
        Toast.makeText(this, mensagemSucesso, Toast.LENGTH_LONG).show()

        limparCampos()
    }

    private fun mostrarErro(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    private fun limparCampos() {
        etNome.text.clear()
        etEmail.text.clear()
        etSenha.text.clear()
        etConfirmarSenha.text.clear()
        etNome.requestFocus()
    }
}