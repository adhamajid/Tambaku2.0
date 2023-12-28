package com.example.tambaku_.Navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tambaku_.MainActivity
import com.example.tambaku_.R

class Tentang : AppCompatActivity() {
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)
        drawerLayout = findViewById(R.id.drawer_layout)
    }

    fun ClickMenu(view: View?) {
        MainActivity.openDrawer(drawerLayout)
    }

    fun ClickLogo(view: View?) {
        MainActivity.closeDrawer(drawerLayout)
    }

    fun ClickHome(view: View?) {
        MainActivity.redirectActivity(this, MainActivity::class.java)
    }

    fun ClickTentang(view: View?) {
        recreate()
    }

    fun ClickKonsul(view: View?) {
        MainActivity.redirectActivity(this, Konsul::class.java)
    }

    fun ClickAboutUs(view: View?) {
        recreate()
    }

    fun ClickKeluar(view: View?) {
        MainActivity.Keluar(this)
    }

    public override fun onPause() {
        super.onPause()
        MainActivity.closeDrawer(drawerLayout)
    }
}