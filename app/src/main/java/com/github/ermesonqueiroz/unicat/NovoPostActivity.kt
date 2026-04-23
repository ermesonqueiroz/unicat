package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NovoPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_post)

        findViewById<android.widget.ImageView>(R.id.btnVoltar).setOnClickListener {
            finish()
        }
    }
}
