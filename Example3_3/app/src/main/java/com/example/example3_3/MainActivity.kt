package com.example.example3_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // activity_main.xml의 android:onClick에서 호출합니다.
    @Suppress("UNUSED_PARAMETER")
    fun showSum(view: View) {
        val first = findViewById<TextView>(R.id.numberOne).text.toString().toInt()
        val second = findViewById<TextView>(R.id.numberTwo).text.toString().toInt()
        Toast.makeText(this, getString(R.string.sum_result, first + second), Toast.LENGTH_SHORT).show()
    }
}
