package com.example.practicaltest01_8

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var rcoordsData = intent.getStringExtra("cheie2") ?: "default_text"

        var my_text = findViewById<TextView>(R.id.main_text)
        my_text.text = rcoordsData

        var inapoi = findViewById<Button>(R.id.activity2_button2).setOnClickListener { v ->
            Toast.makeText(v.context, "OK WAS PRESSED", Toast.LENGTH_SHORT).show()
            finish()
        }

    }


}