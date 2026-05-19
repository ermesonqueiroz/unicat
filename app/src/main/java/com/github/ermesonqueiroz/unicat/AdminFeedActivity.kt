package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * Tela de Moderação do Feed (Admin).
 * Integra a lógica do projeto android_feed_moderation com o layout
 * já existente no unicat (activity_admin_feed.xml).
 *
 * Fluxo:
 *  - "Manter" → diálogo de confirmação → Toast "Post mantido"
 *  - "Excluir" → diálogo de confirmação → Toast "Post excluído"
 */
class AdminFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_feed)

        setupModerationButtons()
        setupNavigation()
    }

    // ------------------------------------------------------------------ //
    //  Lógica de moderação (vinda do android_feed_moderation)             //
    // ------------------------------------------------------------------ //

    private fun setupModerationButtons() {
        // Post 1
        val btnManter = findViewById<Button?>(R.id.btnManter)
        val btnExcluir = findViewById<Button?>(R.id.btnExcluir)

        // Post 2
        val btnManter2 = findViewById<Button?>(R.id.btnManter2)
        val btnExcluir2 = findViewById<Button?>(R.id.btnExcluir2)

        val confirmKeep = {
            AlertDialog.Builder(this)
                .setTitle(R.string.confirm_keep_post_title)
                .setMessage(R.string.confirm_keep_post_message)
                .setPositiveButton(R.string.confirm_yes) { _, _ ->
                    Toast.makeText(this, "Post mantido", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(R.string.confirm_no, null)
                .show()
        }

        val confirmDelete = {
            AlertDialog.Builder(this)
                .setTitle(R.string.confirm_delete_post_title)
                .setMessage(R.string.confirm_delete_post_message)
                .setPositiveButton(R.string.confirm_yes) { _, _ ->
                    Toast.makeText(this, "Post excluído", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(R.string.confirm_no, null)
                .show()
        }

        btnManter?.setOnClickListener { confirmKeep() }
        btnExcluir?.setOnClickListener { confirmDelete() }
        
        btnManter2?.setOnClickListener { confirmKeep() }
        btnExcluir2?.setOnClickListener { confirmDelete() }
    }

    // ------------------------------------------------------------------ //
    //  Navegação                                                           //
    // ------------------------------------------------------------------ //

    private fun setupNavigation() {
        findViewById<View>(R.id.navAdminHome).setOnClickListener {
            startActivity(Intent(this, AdminHomeActivity::class.java))
            finish()
        }

        findViewById<View>(R.id.navAdminGatos).setOnClickListener {
            startActivity(Intent(this, ListaGatosActivity::class.java))
        }

        // ✅ Agora conectado à GestaoUsuariosActivity
        findViewById<View>(R.id.navAdminUsuarios).setOnClickListener {
            startActivity(Intent(this, GestaoUsuariosActivity::class.java))
        }

        findViewById<View>(R.id.navAdminFeed).setOnClickListener {
            // Já está nesta tela
        }

        findViewById<View>(R.id.navAdminMapa).setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }
    }
}
