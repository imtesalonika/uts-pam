package com.ifs21005.myrecycleview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (val planetList : ArrayList<Planet>) : RecyclerView.Adapter<MyAdapter.MyViewHolder> () {
    inner class MyViewHolder (planetView : View) : RecyclerView.ViewHolder(planetView),
        View.OnClickListener {
        var gambarPlanet : ImageView
        var namaPlanet : TextView
        var deskripsiPlanet : TextView

        init {
            gambarPlanet = planetView.findViewById(R.id.imageView)
            namaPlanet = planetView.findViewById(R.id.nama_planet)
            deskripsiPlanet = planetView.findViewById(R.id.deskripsi)

            planetView.setOnClickListener (this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val intent = Intent(v!!.context, DetailPlanetActivity::class.java).apply {
                putExtra("gambarPlanet", planetList[position].gambarPlanet)
                putExtra("namaPlanet", planetList[position].namaPlanet)
                putExtra("deskripsiPlanet", planetList[position].deskripsiPlanet)
                putExtra("detailPlanet", planetList[position].detailPlanet)
            }
            v.context.startActivity(intent)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.planet_item, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.namaPlanet.setText(planetList[position].namaPlanet)
        holder.deskripsiPlanet.setText(planetList[position].deskripsiPlanet)
        holder.gambarPlanet.setImageResource(planetList[position].gambarPlanet)
    }
}
