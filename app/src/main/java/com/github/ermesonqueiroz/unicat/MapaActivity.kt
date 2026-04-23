package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)
        NavigationUtils.setupBottomNavigation(this)
    }
}
