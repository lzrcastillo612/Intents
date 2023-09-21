package com.example.intents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(com.google.android.material.R.id.navigation_header_container,LoveFragment()).commit()

        class LoveFragment : Fragment() {
            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                val loveFragment = inflater.inflate(R.layout.fragment_love, container, false)
                val love : Button =view.findViewById(R.id.loveB)
                bindIsolatedService()
            }
        }
    }
}