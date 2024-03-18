package com.ifs21005.myrecycleview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val buttonAbout : ImageButton = findViewById(R.id.button_profile)

        buttonAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val listPlanet: ArrayList<Planet> = ArrayList()

        val earth = Planet(
            R.drawable.earth,
            "Bumi",
            "Bumi adalah planet terdekat ketiga dari Matahari yang merupakan planet terpadat dan terbesar kelima dari delapan planet dalam Tata Surya.",
            R.string.detail_earth
        )

        val jupiter = Planet(
            R.drawable.jupiter,
            "Jupiter",
            "Jupiter atau Musytari, terkadang secara tidak baku disebut sebagai Yupiter, adalah planet terdekat kelima dari Matahari setelah Merkurius, Venus, Bumi, dan Mars.",
            R.string.detail_jupiter
        )
        val mars = Planet(
            R.drawable.mars,
            "Mars",
            "Mars adalah planet terdekat keempat dari Matahari. Namanya diambil dari dewa perang Romawi, Mars.",
            R.string.detail_mars
        )
        val mercury = Planet(
            R.drawable.mercury,
            "Merkurius",
            "Merkurius merupakan planet terkecil di Tata Surya sekaligus yang terdekat dari Matahari.",
            R.string.detail_mercury
        )
        val neptune = Planet(
            R.drawable.neptune,
            "Neptunus",
            "Neptunus merupakan planet terjauh (kedelapan) jika ditinjau dari Matahari. Planet ini dinamai dari dewa lautan Romawi.",
            R.string.detail_neptune
        )
        val pluto = Planet(
            R.drawable.pluto,
            "Pluto",
            "Pluto (nama planet minor: 134340 Pluto) adalah planet katai di sabuk Kuiper dan objek trans-Neptunus pertama yang ditemukan.",
            R.string.detail_pluto
        )
        val saturnus = Planet(
            R.drawable.saturn,
            "Saturnus",
            "Saturnus (serapan dari Belanda: saturnus) atau zohal (serapan dari bahasa Arab: زحل) adalah planet keenam dari Matahari dan merupakan planet terbesar kedua di Tata Surya setelah Jupiter.",
            R.string.detail_saturn
        )
        val uranus = Planet(
            R.drawable.uranus,
            "Uranus",
            "Uranus (berasal dari nama Latin Ūranus untuk nama dewa Yunani Οὐρανός) adalah planet ketujuh dari Matahari.",
            R.string.detail_uranus
        )
        val venus = Planet(
            R.drawable.venus,
            "Venus",
            "Venus adalah planet terdekat kedua dari Matahari setelah Merkurius. Planet ini mengorbit Matahari selama 224,7 hari Bumi.",
            R.string.detail_venus
        )

        // object object planet yang sudah kita buat sebelumnya akan kita masukkan ke dalam list
        // satu per satu pada bagian ini
        listPlanet.add(earth)
        listPlanet.add(jupiter)
        listPlanet.add(mars)
        listPlanet.add(mercury)
        listPlanet.add(neptune)
        listPlanet.add(pluto)
        listPlanet.add(saturnus)
        listPlanet.add(uranus)
        listPlanet.add(venus)

        // pada bagian ini kita memasukkan list planet yang ada tadi ke dalam class MyAdapter tadi
        // untuk diolah sehingga dapat menampilkan list item yang ada pada recycleview
        val adapter = MyAdapter(listPlanet)
        recyclerView.adapter = adapter
    }
}