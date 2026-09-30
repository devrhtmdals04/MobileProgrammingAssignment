package com.example.example3_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.graphics.Typeface
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.helloText)
        textView.setText(R.string.hello)
        textView.setTextColor(Color.parseColor("#03A9F4"))
        textView.setTypeface(Typeface.SERIF)
        textView.setTextSize(50f)
    }
}
