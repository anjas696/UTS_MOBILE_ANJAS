package com.example.uts_anjasrestumuliaadh32602100031i

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photo = intent.getIntExtra("photo", R.drawable.ic_launcher_foreground)
        val title = intent.getStringExtra("title") ?: "Judul Artikel"
        val description = intent.getStringExtra("description") ?: "Deskripsi Artikel"
        val keterangan = intent.getStringExtra("keterangan") ?: "Artikel"
        //tvDetailKeterangan.text = keterangan

        //tvDetailKeterangan.text = keterangan

        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailTitle: TextView = findViewById(R.id.tv_detail_title)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvDetailKeterangan: TextView = findViewById(R.id.tv_detail_keterangan)  // Tambahkan ini

        ivDetailPhoto.setImageResource(photo)
        tvDetailTitle.text = title
        tvDetailDescription.text = description
        tvDetailKeterangan.text = keterangan  // Tambahkan ini
    }
}