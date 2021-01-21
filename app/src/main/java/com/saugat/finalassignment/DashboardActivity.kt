package com.saugat.finalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saugat.finalassignment.fragments.HomeFragment
import java.lang.Exception

class DashboardActivity : AppCompatActivity() {
    private lateinit var botomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        botomNav = findViewById(R.id.botomNav)

        currentFragment(HomeFragment())

        botomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> currentFragment(HomeFragment())
            }
            true
        }
    }

    private fun currentFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, fragment)
                addToBackStack(null)
                commit()
            }
        }
        catch (ex:Exception){
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }
}