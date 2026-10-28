package com.example.mp0604

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val	editText: EditText = findViewById(R.id.editText)
        val	button:	Button = findViewById(R.id.button);
        button.setOnClickListener {
            val input = editText.text.toString().trim()
            if (input.isEmpty()) {
                editText.error = "웹 주소를 입력하세요"
                return@setOnClickListener
            }
            val uri = Uri.parse(if ("://" in input) input else "https://$input")
            if (uri.scheme?.lowercase() !in listOf("http", "https") || uri.host.isNullOrBlank()) {
                editText.error = "올바른 웹 주소를 입력하세요"
                return@setOnClickListener
            }
            try {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(this, "웹 브라우저 앱이 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}