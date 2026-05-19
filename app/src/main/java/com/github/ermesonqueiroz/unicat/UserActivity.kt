package com.github.ermesonqueiroz.unicat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        if (savedInstanceState == null) {
            replaceFragment(UserMap())
        }


        val nav = findViewById<BottomNavigationView>(R.id.bottomNavigationView);
        nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.userNavMap -> replaceFragment(UserMap())
                R.id.userNavSearch -> replaceFragment(UserCatListFragment())
                R.id.userNavFeed -> replaceFragment(UserFeedFragment())
                R.id.userNavProfile -> replaceFragment(UserProfileFragment())
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}
