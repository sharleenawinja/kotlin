package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)

        next.setOnClickListener {
            var idCurrentImageString = "pic$currentImage"

            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage = (5+currentImage+1)%5

            var idImageToShowString = "pic$currentImage"

            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)

            image = findViewById(idImageToShowInt)
            image.alpha=1f

        }

        prev.setOnClickListener {
            var idCurrentImageString = "pic$currentImage"

            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage = (5+currentImage-1)%5

            var idImageToShowString = "pic$currentImage"

            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)

            image = findViewById(idImageToShowInt)
            image.alpha=1f
        }
    }
}