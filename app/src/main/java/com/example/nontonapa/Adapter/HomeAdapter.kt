package com.example.nontonapa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nontonapa.R
import com.example.nontonapa.film
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val listFilm : ArrayList<film>, val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.Homeholder>() {

    interface OnItemClickListener {
        fun onClick(film : film)
    }

    class Homeholder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        fun bind(film : film, listener: OnItemClickListener) {
            with(itemView) {
                Picasso.get()
                    .load(film.thumbnail)
                    .into(thumbnail_img)
                titletv.text = film.title
                ratingtv.text = film.rating

                itemView.setOnClickListener {
                    listener.onClick(film)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Homeholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return Homeholder(view)
    }

    override fun onBindViewHolder(holder: Homeholder, position: Int) {
        holder.bind(listFilm[position], listener)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}