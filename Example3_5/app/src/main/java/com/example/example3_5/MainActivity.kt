package com.example.example3_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageIndex = savedInstanceState?.getInt("imageIndex", 0) ?: 0
        showImage()
        findViewById<View>(R.id.nextButton).setOnClickListener {
            imageIndex = (imageIndex + 1) % images.size
            showImage()
        }
    }

    private val images = intArrayOf(R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5)
    private var imageIndex = 0

    private fun showImage() {
        findViewById<ImageView>(R.id.catImage).apply {
            setImageResource(images[imageIndex])
            contentDescription = getString(R.string.cat_description, imageIndex + 1)
        }
        findViewById<TextView>(R.id.imageName).text = getString(R.string.image_filename, imageIndex + 1)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("imageIndex", imageIndex)
        super.onSaveInstanceState(outState)
    }
}
