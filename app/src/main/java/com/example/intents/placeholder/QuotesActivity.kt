package com.example.intents.placeholder

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.intents.R
import kotlin.random.Random

class QuotesActivity : AppCompatActivity() {
    private lateinit var quoteTextView: TextView
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        quoteTextView = findViewById(R.id.quotes)
        saveButton = findViewById(R.id.save)

        val quoteType = intent.getStringExtra("quoteType")


        val quotes = when (quoteType) {
            "love" -> arrayOf("Loving you isn't just a feeling; it's a promise to always be by your side, to hold you close, and to cherish you forever.",
                "Closeness with you is a treasure I hold dear. You are the sunshine in my darkest days.",
                "I never knew how much I could love someone until I met you. Being close to you feels like home.",
                "Loving you is not just a feeling; it's a connection that keeps us close, no matter where we are.",
                "You are my confidant, my best friend, and the love of my life. Being close to you is where I belong.",
                "Our love is like a strong magnet; it keeps pulling us closer, no matter what challenges we face.")

            "motivational" -> arrayOf("Challenges are what make life interesting. Overcoming them is what makes life meaningful. - Joshua J. Marine",
                "Opportunities don't happen. You create them. - Chris Grosser",
                "You are never too old to set another goal or to dream a new dream. - C.S. Lewis",
                "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
                "The only way to do great work is to love what you do. - Steve Jobs",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill")

            "funny" -> arrayOf("Behind every great man, there is a woman rolling her eyes. - Jim Carrey",
                "If you think you are too small to make a difference, try sleeping with a mosquito. - Dalai Lama",
                "The human brain is amazing. It functions 24/7 from the day we're born, and only stops when we're asked to speak in public. - Jerry Seinfeld",
                "If a book about failures doesn't sell, is it a success? - Jerry Seinfeld",
                "The trouble with having an open mind, of course, is that people will insist on coming along and trying to put things in it. - Terry Pratchett",
                "I'm not sure if I actually have free time or if I just keep forgetting stuff I'm supposed to do. - Anonymous")
            else -> arrayOf()
        }


        val randomIndex = Random.nextInt(quotes.size)
        val randomQuote = quotes[randomIndex]


        quoteTextView.text = randomQuote

        saveButton.setOnClickListener {
            val quote = randomQuote
            if (quote.isNotEmpty()) {
                saveQuoteToSharedPreferences(quoteType, quote)
                Toast.makeText(this, "Quote Saved.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveQuoteToSharedPreferences(quoteType: String?, quote: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyQuotes", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val key = "$quoteType" + "_quote"
        editor.putString(key, quote)
        editor.apply()

    }
}