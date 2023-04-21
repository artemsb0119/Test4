package com.example.testovoe4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide

class FootballScoreActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private lateinit var textViewMax: TextView
    private lateinit var textViewLevel: TextView
    private lateinit var buttonRetry: AppCompatButton
    private lateinit var imageViewFon2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football_score)

        textViewResult = findViewById(R.id.textViewResult)
        textViewMax = findViewById(R.id.textViewMax)
        textViewLevel = findViewById(R.id.textViewLevel)
        buttonRetry = findViewById(R.id.buttonRetry)
        imageViewFon2 = findViewById(R.id.imageViewFon2)
        val result = intent.getIntExtra("current",0)
        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val max = sharedPreferences.getInt("max", 0)
        val score = String.format("Your result: %s", result)
        textViewResult.text = score
        val maxResult = String.format("Maximum result: %s", max)
        textViewMax.text = maxResult
        textViewResult.text = score
        val level = when (result) {
            in 0..5 -> "Reserve player"
            in 6..9 -> "Main player"
            in 10..12 -> "Captain"
            in 13..14 -> "Star"
            else -> "Best player"
        }
        val resLevel = String.format("Your level: %s", level)
        textViewLevel.text = resLevel

        buttonRetry.setOnClickListener {
            val intent = Intent(this, FootballActivity::class.java)
            startActivity(intent)
            finish()
        }

        Glide.with(this)
            .load("http://135.181.248.237/4/football.png")
            .into(imageViewFon2)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
        return super.onKeyDown(keyCode, event)
    }
}