package com.hanifah.latihan5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnKonversiSuhu : Button
    private lateinit var btnDiskon : Button
    private lateinit var btnLuasVolume : Button
    private lateinit var btnGanjilGenap : Button
    private lateinit var btnList:  Button
    private lateinit var btnpassing : Button
    private lateinit var btnRecycleView : Button
    private lateinit var btnBuah : Button
    private lateinit var btnMovie:  Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnKonversiSuhu = findViewById(R.id.btnKonversiSuhu)
        btnDiskon = findViewById(R.id.btnDiskon)
        btnLuasVolume = findViewById(R.id.btnLuasVolume)
        btnGanjilGenap = findViewById(R.id.btnGanjilGenap)
        btnList = findViewById(R.id.btnList)
        btnpassing = findViewById(R.id.btnpassing)
        btnRecycleView = findViewById<Button>(R.id.btnRecycleView)
        btnBuah = findViewById<Button>(R.id.btnBuah)
        btnMovie = findViewById<Button>(R.id.btnMovie)


        btnKonversiSuhu.setOnClickListener(){
            val intent = Intent(this, konversiSuhu::class.java)
            startActivity(intent)
        }

        btnDiskon.setOnClickListener(){
            val intent = Intent(this, diskon::class.java)
            startActivity(intent)
        }
        btnLuasVolume.setOnClickListener(){
            val intent = Intent(this, luas_volume::class.java)
            startActivity(intent)
        }
        btnGanjilGenap.setOnClickListener(){
            val intent = Intent(this, ganjil_genap::class.java)
            startActivity(intent)
        }

        btnList.setOnClickListener(){
            val intent = Intent(this, list_view::class.java)
            startActivity(intent)

        }
        btnpassing.setOnClickListener(){
            val intent = Intent(this, passing_data::class.java)
            startActivity(intent)

        }
        btnRecycleView.setOnClickListener(){
            val intent = Intent(this, RvBuku::class.java)
            startActivity(intent)
        }
        btnBuah.setOnClickListener() {
            val intent = Intent(this, customImage::class.java)
            startActivity(intent)
        }

        btnMovie.setOnClickListener() {
            val intent = Intent(this, RvCardMovie::class.java)
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}