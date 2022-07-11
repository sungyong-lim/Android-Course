package com.example.dobcalc


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHours: Button = findViewById(R.id.startBtnHours)
        val btnMinutes: Button = findViewById(R.id.startBtnMinutes)

        btnHours.setOnClickListener { startActivity(Intent(this, HoursActivity::class.java)) }
        btnMinutes.setOnClickListener { startActivity(Intent(this, MinutesActivity::class.java)) }


    }

}