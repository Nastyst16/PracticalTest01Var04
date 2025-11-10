package com.example.practicaltest01_8

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var firstButton = true

    var text_afisat = "primul text"
//    var text1 = "legen sula"
//    var text2 = "silverchest OP"

    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {

            if (view.id == R.id.button1) {
                var textview = findViewById<TextView>(R.id.left_text)

                if (firstButton == true) {
                    text_afisat = "legen sula"
                    textview.text = text_afisat
                    firstButton = false
                } else {
                    text_afisat = "silverchest OP"
                    textview.text = text_afisat
                    firstButton = true
                }

            }

            if (view.id == R.id.button2) {

            }



        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val buttons = listOf(
            R.id.button1, R.id.button2
        )

        val toggleButton = ButtonClickListener()
        for (id in buttons) {
            findViewById<View>(id).setOnClickListener(toggleButton)
        }


        var navigate = findViewById<TextView>(R.id.button2).setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("cheie2", text_afisat)
            startActivity(intent)
        }
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("cheie", text_afisat.toString())
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        var refacere = findViewById<TextView>(R.id.left_text)
        text_afisat = savedInstanceState.getString("cheie", "default_value")
        refacere.text = text_afisat
    }

}