package com.hanifah.latihan5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class diskon : AppCompatActivity() {
    private lateinit var bayar : EditText
    private lateinit var input : Button
    private lateinit var total : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diskon)

        bayar =  findViewById(R.id.etTotalBelanja)
        input =  findViewById(R.id.btnHitungDiskon)
        total = findViewById(R.id.tvHasilDiskon)

        input.setOnClickListener()
        {
            val totalBelanja = bayar.text.toString().toDouble()
            val hargaAkhir = if (totalBelanja < 100000) {
                totalBelanja // Tidak ada diskon
            } else if (totalBelanja in 100000.0..500000.0) {
                totalBelanja * 0.90 // Diskon 10%
            } else if (totalBelanja in 500000.0..1000000.0) {
                totalBelanja * 0.80 // Diskon 20%
            } else if (totalBelanja > 1000000.0) {
                totalBelanja * 0.70 // Diskon 30%
            } else {
                totalBelanja // Default case
            }

            // Menampilkan hasil harga akhir
            total.text = "Total bayar: Rp. ${"%.2f".format(hargaAkhir)}"


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}