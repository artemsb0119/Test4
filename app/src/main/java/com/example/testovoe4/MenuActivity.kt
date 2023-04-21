package com.example.testovoe4

import Quiz
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class MenuActivity : AppCompatActivity() {

    private lateinit var buttonFootball: AppCompatButton
    private lateinit var buttonBasketball: AppCompatButton
    private lateinit var buttonHockey: AppCompatButton
    private lateinit var buttonSettings: AppCompatButton
    private lateinit var imageViewFon2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonFootball = findViewById(R.id.buttonFootball)
        buttonBasketball = findViewById(R.id.buttonBasketball)
        buttonHockey = findViewById(R.id.buttonHockey)
        buttonSettings = findViewById(R.id.buttonSettings)
        imageViewFon2 = findViewById(R.id.imageViewFon2)

        Glide.with(this)
            .load("http://135.181.248.237/4/fon2.png")
            .into(imageViewFon2)

        buttonFootball.setOnClickListener {
            val intent = Intent(this, FootballActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonBasketball.setOnClickListener {
            val intent = Intent(this, BasketballActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonHockey.setOnClickListener {
            val intent = Intent(this, HockeyActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

}