package com.example.example3_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.resultButton).setOnClickListener {
            findViewById<TextView>(R.id.resultText).text = getString(
                R.string.form_result,
                findViewById<EditText>(R.id.nameInput).text.toString(),
                findViewById<EditText>(R.id.passwordInput).text.toString(),
                findViewById<EditText>(R.id.emailInput).text.toString(),
                findViewById<EditText>(R.id.birthdayInput).text.toString(),
                findViewById<EditText>(R.id.phoneInput).text.toString()
            )
        }
    }
}
