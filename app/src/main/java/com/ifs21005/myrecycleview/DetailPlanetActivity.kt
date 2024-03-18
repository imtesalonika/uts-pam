package com.ifs21005.myrecycleview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPlanetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_planet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // gambar planet yang dari intent di MyAdapter masuk ke sini
        val gambarPlanet = intent.getIntExtra("gambarPlanet", 0)

        // nama planet yang dari intent di MyAdapter masuk ke sini
        val namaPlanet = intent.getStringExtra("namaPlanet")

        // detail planet yang dari intent di MyAdapter masuk ke sini
        val detailPlanet = intent.getIntExtra("detailPlanet", 0)

        // deskripso planet yang dari intent di MyAdapter masuk ke sini
        val deskripsiPlanet = intent.getStringExtra("deskripsiPlanet")

        // pada bagian ini kita menyimpan view view yang ada di activity_detail_planet ke dalam
        // variable
        val gambarPlanetImageView : ImageView = findViewById(R.id.gambar_planet_detail)
        val namaPlanetTextView : TextView = findViewById(R.id.nama_planet_detail)
        val detailPlanetTextView : TextView = findViewById(R.id.detail_planet)

        // pada bagian di bawah ini kita memasukkan data yang dikirimkan dari intent tadi
        // ke dalam view view yang ada pada activity_detail_planet
        findViewById<TextView>(R.id.nama_planet_toolbar).text = namaPlanet
        gambarPlanetImageView.setImageResource(gambarPlanet)
        namaPlanetTextView.text = namaPlanet
        detailPlanetTextView.setText(detailPlanet)

        // mendefenisikan tombol back dan tombol share dari view yang ada pada activity_detail_planet
        val tombolBack : ImageView = findViewById(R.id.tombol_back_about)
        val tombolShare : ImageView = findViewById(R.id.tombol_share)

        // ketika tombol back ditekan, maka tampilan detail activity akan berakher dan kembali
        // ke main activity
        tombolBack.setOnClickListener {
            finish()
        }

        // disini kita mengimplementasikan tombol share yang ada pada activity_detail_planet
        tombolShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "${namaPlanetTextView.text}\n\n${deskripsiPlanet}")
            startActivity(Intent.createChooser(intent, "Bagikan melalui"))
        }
    }

}