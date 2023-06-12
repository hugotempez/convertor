package com.example.convertor_exo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class KgActivity : AppCompatActivity() {

    private lateinit var layout: View
    private lateinit var textViewTitre: TextView
    private lateinit var inputEdit1: TextInputEditText
    private lateinit var inputEdit2: TextInputEditText
    private lateinit var buttonConvertToKg: Button
    private lateinit var buttonConvertToLivres: Button
    private lateinit var buttonPieds: Button
    private lateinit var buttonPouces: Button
    private lateinit var buttonSpeed: Button
    private lateinit var buttonMain: Button
    private var fontSize: Float = 0f
    private var darkMode: Boolean = false
    private var black = -16777216
    private var white= -1
    private var conv = 0.45

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kg)
        layout = findViewById(R.id.kgLayout)
        textViewTitre = findViewById(R.id.textViewKgTitre)
        inputEdit1 = findViewById(R.id.inputEditKg1)
        inputEdit2 = findViewById(R.id.inputEditKg2)
        buttonMain = findViewById(R.id.buttonKgToMain)
        buttonPieds = findViewById(R.id.buttonKgToPieds)
        buttonPouces = findViewById(R.id.buttonKgToPouces)
        buttonSpeed = findViewById(R.id.buttonKgToSpeed)
        buttonConvertToKg = findViewById(R.id.buttonKgConvertToKg)
        buttonConvertToLivres = findViewById(R.id.buttonKgConvertToLivres)
        val data = intent.extras
        if (data != null) {
            fontSize = data.getFloat("fontSize")
            darkMode = data.getBoolean("darkMode")
            viewDesignHandler(darkMode, fontSize)
        }
        buttonConvertToLivres.setOnClickListener {
            try {
                inputEdit2.setText((inputEdit1.text.toString().toDouble() * conv).toString())
            } catch (_: Exception) {
                inputEdit1.setText("Erreur")
                inputEdit2.setText("Erreur")
            }
        }
        buttonConvertToKg.setOnClickListener {
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
            startActivity(intent)
        }
        buttonPieds.setOnClickListener {
            val intent = Intent(this, PiedsActivity::class.java)
            startActivity(intent)
        }
        buttonPouces.setOnClickListener {
            val intent = Intent(this, PoucesActivity::class.java)
            startActivity(intent)
        }
        buttonSpeed.setOnClickListener {
            val intent = Intent(this, SpeedActivity::class.java)
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
