package com.example.convertor_exo3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var layout: View
    private lateinit var textViewTitre: TextView
    private lateinit var buttonKg: Button
    private lateinit var buttonPieds: Button
    private lateinit var buttonPouces: Button
    private lateinit var buttonSpeed: Button
    private lateinit var buttonSettings: Button
    private var fontSize: Float = 14f
    private var darkMode: Boolean = false
    private var black = -16777216
    private var white= -1

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
        buttonKg.setOnClickListener {
            val intent = Intent(this, KgActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
            startActivity(intent)
        }
        buttonPieds.setOnClickListener {
            val intent = Intent(this, PiedsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
            startActivity(intent)
        }
        buttonPouces.setOnClickListener {
            val intent = Intent(this, PoucesActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
            startActivity(intent)
        }
        buttonSpeed.setOnClickListener {
            val intent = Intent(this, SpeedActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
            startActivity(intent)
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