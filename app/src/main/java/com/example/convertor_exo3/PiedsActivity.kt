package com.example.convertor_exo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class PiedsActivity : AppCompatActivity() {

    private lateinit var layout: View
    private lateinit var textViewTitre: TextView
    private lateinit var inputEdit1: TextInputEditText
    private lateinit var inputEdit2: TextInputEditText
    private lateinit var buttonConvertToPieds: Button
    private lateinit var buttonConvertToMetres: Button
    private lateinit var buttonPouces: Button
    private lateinit var buttonKg: Button
    private lateinit var buttonSpeed: Button
    private lateinit var buttonMain: Button
    private var fontSize: Float = 0f
    private var darkMode: Boolean = false
    private var black = -16777216
    private var white= -1
    private var conv = 3.28

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pieds)
        layout = findViewById(R.id.piedsLayout)
        textViewTitre = findViewById(R.id.textViewPiedsTitre)
        inputEdit1 = findViewById(R.id.inputEditSpeed1)
        inputEdit2 = findViewById(R.id.inputEditSpeed2)
        buttonMain = findViewById(R.id.buttonPiedsToMain)
        buttonKg = findViewById(R.id.buttonPiedsToKg)
        buttonPouces = findViewById(R.id.buttonPiedsToPouces)
        buttonSpeed = findViewById(R.id.buttonPiedsToSpeed)
        buttonConvertToPieds = findViewById(R.id.buttonPiedsConvertToPieds)
        buttonConvertToMetres = findViewById(R.id.buttonPiedsConvertToMetres)
        val data = intent.extras
        if (data != null) {
            fontSize = data.getFloat("fontSize")
            darkMode = data.getBoolean("darkMode")
            viewDesignHandler(darkMode, fontSize)
            Log.d("fontSize", fontSize.toString())
            Log.d("darkMode", darkMode.toString())
        }
        buttonConvertToMetres.setOnClickListener {
            try {
                inputEdit2.setText((inputEdit1.text.toString().toDouble() / conv).toString())
            } catch (_: Exception) {
                inputEdit1.setText("Erreur")
                inputEdit2.setText("Erreur")
            }
        }
        buttonConvertToPieds.setOnClickListener {
            try {
                inputEdit1.setText((inputEdit2.text.toString().toDouble() * conv).toString())
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