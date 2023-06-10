package com.example.convertor_exo3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView


class SettingsActivity : AppCompatActivity() {

    lateinit var layout: View
    var fontSize: Float = 14.3f
    var black: Int = -16777216
    var white: Int = -1
    lateinit var textViewTitreSettings: TextView
    lateinit var textViewFontSize: TextView
    lateinit var seekBarFontSize: SeekBar
    lateinit var textViewFontSizeValue: TextView
    lateinit var switchDarkMode: Switch
    lateinit var buttonReturnSettings: Button
    var darkMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        layout = findViewById(R.id.settingsLayout)
        buttonReturnSettings = findViewById(R.id.buttonReturnSettings)
        textViewFontSizeValue = findViewById(R.id.textViewFontSizeValue)
        textViewTitreSettings = findViewById(R.id.textViewTitreSettings)
        textViewFontSize = findViewById(R.id.textViewFontSize)
        seekBarFontSize = findViewById(R.id.seekBarFontSize)
        seekBarFontSize.progress = 24
        switchDarkMode = findViewById(R.id.switchDarkMode)
        switchDarkMode.setOnClickListener {
            if (switchDarkMode.isChecked) {
                darkMode = true
                layout.setBackgroundColor(black)
                textViewFontSize.setTextColor(white)
                textViewTitreSettings.setTextColor(white)
                textViewFontSizeValue.setTextColor(white)
                switchDarkMode.setTextColor(white)
            } else {
                darkMode = false
                layout.setBackgroundColor(white)
                textViewFontSize.setTextColor(black)
                textViewTitreSettings.setTextColor(black)
                textViewFontSizeValue.setTextColor(black)
                switchDarkMode.setTextColor(black)
            }
        }
        seekBarFontSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val offset: Float = 0.3f
                Log.d("progress", p1.toString())
                fontSize = 12 + (p1 / 12).toFloat()
                textViewFontSizeValue.text = fontSize.toInt().toString()
                textViewFontSizeValue.textSize = fontSize + offset
                textViewFontSize.textSize = fontSize + offset
                textViewTitreSettings.textSize = fontSize + offset
                switchDarkMode.textSize = fontSize + offset
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        buttonReturnSettings.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("fontSize", fontSize)
            intent.putExtra("darkMode", darkMode)
            startActivity(intent)
        }
    }
}