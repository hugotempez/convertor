package com.example.convertor_exo3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var layout: View
    lateinit var textViewTitre: TextView
    lateinit var buttonKg: Button
    lateinit var buttonPieds: Button
    lateinit var buttonPouces: Button
    lateinit var buttonSpeed: Button
    lateinit var buttonSettings: Button
    var fontSize: Float = 0f
    var darkMode: Boolean = false
    var black = -16777216
    var white= -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = findViewById(R.id.mainLayout)
        textViewTitre = findViewById(R.id.textViewTitre)
        buttonKg = findViewById(R.id.buttonKg)
        buttonPieds = findViewById(R.id.buttonPieds)
        buttonPouces = findViewById(R.id.buttonPouces)
        buttonSpeed = findViewById(R.id.buttonSpeed)
        buttonSettings = findViewById(R.id.buttonSettings)
        val data = intent.extras
        if (data != null) {
            fontSize = data.getFloat("fontSize")
            darkMode = data.getBoolean("darkMode")
            viewDesignHandler(darkMode, fontSize)
        }
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }
    }

    private fun viewDesignHandler(darkMode: Boolean, fontSize: Float) {
        if (darkMode) {
            layout.setBackgroundColor(black)
            textViewTitre.setTextColor(white)
        } else {
            layout.setBackgroundColor(white)
            textViewTitre.setTextColor(black)
        }
        textViewTitre.textSize = fontSize
    }
}