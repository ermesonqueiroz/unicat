package com.github.ermesonqueiroz.unicat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        NavigationUtils.setupBottomNavigation(this)

        findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabNovoPost).setOnClickListener {
            startActivity(Intent(this, NovoPostActivity::class.java))
        }

        findViewById<android.widget.ImageView>(R.id.btnNovoPost).setOnClickListener {
            startActivity(Intent(this, NovoPostActivity::class.java))
        }
    }
}
