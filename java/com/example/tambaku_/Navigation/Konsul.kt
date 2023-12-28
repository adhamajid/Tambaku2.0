package com.example.tambaku_.Navigation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.tambaku_.R

class Konsul : AppCompatActivity() {
    private var endang: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konsul)
        endang = findViewById(R.id.endang)
        endang?.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("http://wa.me/628994163562")
            startActivity(intent)
        }
    }
}