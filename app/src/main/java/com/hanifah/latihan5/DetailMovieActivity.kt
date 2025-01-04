package com.hanifah.latihan5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailMovieActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail_movie)

        val imageView = findViewById<ImageView>(R.id.imgMovie)
        val textViewTitle = findViewById<TextView>(R.id.textjuduldetail)
        val tanggaldesc = findViewById<TextView>(R.id.tctDetailRelease)
        val sinopsisdesc = findViewById<TextView>(R.id.txtDetailSinopsi)

        val imageResId = intent.getIntExtra("image", 0)
        val title = intent.getStringExtra("title")
        val tanggal = intent.getStringExtra("tanggal")
        val sinopsis = intent.getStringExtra("sinopsis")


        imageView.setImageResource(imageResId)
        textViewTitle.text = title ?: "No Title"
        tanggaldesc.setText(tanggal)
        sinopsisdesc.setText(sinopsis)





    }
}