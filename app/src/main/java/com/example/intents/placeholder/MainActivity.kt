package com.example.intents.placeholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.example.intents.R

class MainActivity : AppCompatActivity() {
    private lateinit var lovebutt: Button
    private lateinit var motivbutt: Button
    private lateinit var funnybutt: Button
    private lateinit var favebutt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lovebutt = findViewById(R.id.lovebutt)
        motivbutt = findViewById(R.id.motivbutt)
        funnybutt = findViewById(R.id.funnybutt)
        favebutt = findViewById(R.id.favebutt)

        lovebutt.setOnClickListener {
            startQuotesActivity("Love")
        }
        motivbutt.setOnClickListener {
            startQuotesActivity("Motivational")
        }
        funnybutt.setOnClickListener {
            startQuotesActivity("Funny")
        }
        favebutt.setOnClickListener {
            startFavoritesActivity()
        }
    }

    private fun startQuotesActivity(category: String) {
        val intent = Intent(this, QuotesActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    private fun startFavoritesActivity() {
        val intent = Intent(this, FavoritesActivity::class.java)
        startActivity(intent)
    }
}
