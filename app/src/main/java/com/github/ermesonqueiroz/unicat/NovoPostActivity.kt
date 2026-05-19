package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class NovoPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_post)

        // Voltar
        findViewById<android.widget.ImageView>(R.id.btnVoltar)?.setOnClickListener {
            finish()
        }

        // Selecionar foto — popup informativo
        findViewById<android.view.View>(R.id.layoutFoto)?.setOnClickListener {
            Toast.makeText(this, "Selecionar foto da galeria", Toast.LENGTH_SHORT).show()
        }

        // Selecionar gato — popup informativo
        findViewById<android.view.View>(R.id.layoutGatos)?.setOnClickListener {
            Toast.makeText(this, "Selecionar gato para marcar", Toast.LENGTH_SHORT).show()
        }

        // Publicar → confirmação e volta
        findViewById<android.widget.Button>(R.id.btnPublicar)?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Publicar post")
                .setMessage("Deseja publicar este post no feed?")
                .setPositiveButton("Publicar") { _, _ ->
                    Toast.makeText(this, "Post publicado com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }
}
