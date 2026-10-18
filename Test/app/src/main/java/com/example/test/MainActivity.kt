package com.example.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonHot = findViewById<Button>(R.id.btnHot)
        val buttonCool = findViewById<Button>(R.id.btnCool)
        val main = findViewById<LinearLayout>(R.id.main)

        buttonHot.setOnClickListener {
            main.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        }

        buttonCool.setOnClickListener {
            main.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }
    }
}