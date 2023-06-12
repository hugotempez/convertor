package com.example.convertor_exo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class PiedsActivity : AppCompatActivity() {

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
    private var conv = 0.45

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pieds)
    }

    /*private fun viewDesignHandler(darkMode: Boolean, fontSize: Float) {
        if (darkMode) {
            layout.setBackgroundColor(black)
            textViewTitre.setTextColor(white)
        } else {
            layout.setBackgroundColor(white)
            textViewTitre.setTextColor(black)
        }
        textViewTitre.textSize = fontSize
    }*/
}