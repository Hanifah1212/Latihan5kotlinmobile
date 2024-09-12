package com.hanifah.latihan5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class passing_data : AppCompatActivity() {
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnLogin: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_passing_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etpassword = findViewById(R.id.etpassword)
        etusername = findViewById(R.id.etusername)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            //passing data dg intent -> m
            var intent = Intent(this@passing_data, welcome::class.java)
            val nUsername = etusername.text.toString()
            val nPassword = etpassword.text.toString()

            intent.putExtra("username", nUsername)
            intent.putExtra("password", nPassword)

            Log.d("username", nUsername)
            Log.d("password", nPassword)
            startActivity(intent)
        }
    }
}