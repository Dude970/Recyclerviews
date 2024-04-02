package com.example.widgets

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class Activity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)

        val btn = findViewById<Button>(R.id.btn1)
        val btn1 = findViewById<Button>(R.id.btn2)
        val btn2 = findViewById<Button>(R.id.btn3)
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
          btn.setOnClickListener {

              val intent = Intent(this, MainActivity::class.java)
              startActivity(intent)
          }

        btn1.setOnClickListener {

              val intent = Intent(this, Second::class.java)
              startActivity(intent)
          }
        btn2.setOnClickListener {

              val intent = Intent(this, ManyActivity::class.java)
              startActivity(intent)
          }


    }
}