package com.example.convertor_exo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class PoucesActivity : AppCompatActivity() {

    private lateinit var layout: View
    private lateinit var textViewTitre: TextView
    private lateinit var inputEdit1: TextInputEditText
    private lateinit var inputEdit2: TextInputEditText
    private lateinit var buttonConvertToPouces: Button
    private lateinit var buttonConvertToMetres: Button
    private lateinit var buttonPieds: Button
    private lateinit var buttonKg: Button
    private lateinit var buttonSpeed: Button
    private lateinit var buttonMain: Button
    private var fontSize: Float = 0f
    private var darkMode: Boolean = false
    private var black = -16777216
    private var white= -1
    private var conv = 39.37

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pouces)
        layout = findViewById(R.id.poucesLayout)
        textViewTitre = findViewById(R.id.textViewPoucesTitre)
        inputEdit1 = findViewById(R.id.inputEditSpeed1)
        inputEdit2 = findViewById(R.id.inputEditSpeed2)
        buttonMain = findViewById(R.id.buttonPoucesToMain)
        buttonKg = findViewById(R.id.buttonPoucesToKg)
        buttonPieds = findViewById(R.id.buttonPoucesToPieds)
        buttonSpeed = findViewById(R.id.buttonPoucesToSpeed)
        buttonConvertToPouces = findViewById(R.id.buttonPoucesConvertToPouces)
        buttonConvertToMetres = findViewById(R.id.buttonPoucesConvertToMetres)
        val data = intent.extras
        if (data != null) {
            fontSize = data.getFloat("fontSize")
            darkMode = data.getBoolean("darkMode")
            viewDesignHandler(darkMode, fontSize)
        }
        buttonConvertToPouces.setOnClickListener {
            try {
                inputEdit2.setText((inputEdit1.text.toString().toDouble() * conv).toString())
            } catch (_: Exception) {
                inputEdit1.setText("Erreur")
                inputEdit2.setText("Erreur")
            }
        }
        buttonConvertToMetres.setOnClickListener {
            try {
                inputEdit1.setText((inputEdit2.text.toString().toDouble() / conv).toString())
            } catch (_: Exception) {
                inputEdit1.setText("Erreur")
                inputEdit2.setText("Erreur")
            }
        }
        buttonMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
            startActivity(intent)
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
        buttonSpeed.setOnClickListener {
            val intent = Intent(this, SpeedActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
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