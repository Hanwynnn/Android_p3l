package com.example.p3l_android.home.homeInstruktur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.p3l_android.R
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import android.content.DialogInterface
import android.content.Intent

class Home_Instruktur : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_instruktur)

        val botNav : NavigationBarView = findViewById(R.id.bottom_navigation)

        botNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.profile -> {
                    changeFragment(instruktur_fragment())
                    true
                }
                else -> false
            }
        }
    }

    fun changeFragment(fragment: Fragment){
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.layout_fragment, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.home_member_menu, menu)
        return true
    }
}