package com.github.ermesonqueiroz.unicat

import android.app.Activity
import android.content.Intent
import android.view.View

object NavigationUtils {
    fun setupBottomNavigation(activity: Activity) {
        activity.findViewById<View>(R.id.navMapa)?.setOnClickListener {
            if (activity !is MapaActivity) {
                activity.startActivity(Intent(activity, MapaActivity::class.java))
            }
        }
        activity.findViewById<View>(R.id.navGatos)?.setOnClickListener {
            if (activity !is ListaGatosActivity) {
                activity.startActivity(Intent(activity, ListaGatosActivity::class.java))
            }
        }
        activity.findViewById<View>(R.id.navFeed)?.setOnClickListener {
            if (activity !is FeedActivity) {
                activity.startActivity(Intent(activity, FeedActivity::class.java))
            }
        }
        activity.findViewById<View>(R.id.navPerfil)?.setOnClickListener {
            if (activity !is PerfilPessoaActivity) {
                activity.startActivity(Intent(activity, PerfilPessoaActivity::class.java))
            }
        }
    }
}
