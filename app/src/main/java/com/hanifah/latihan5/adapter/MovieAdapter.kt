package com.hanifah.latihan5.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hanifah.latihan5.DetailMovieActivity
import com.hanifah.latihan5.Model.ModelMovie
import com.hanifah.latihan5.R
import com.hanifah.latihan5.RvCardMovie

class MovieAdapter(
    private val activity: RvCardMovie, // Activity sebagai konteks
    private val movieList: List<ModelMovie>, // List data film
    private val itemClickListener: (Int) -> Unit // Listener klik item
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // ViewHolder untuk mengelola view di item layout
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.txtMovie.text = movie.title
        holder.imgMovie.setImageResource(movie.image)

        // Menambahkan event klik untuk setiap item
        holder.cardView.setOnClickListener {
            val intent = Intent(activity, DetailMovieActivity::class.java).apply {
                putExtra("image", movie.image)
                putExtra("title", movie.title)
                putExtra("tanggal", movie.tanggal)
                putExtra("sinopsis", movie.sinopsis)
            }
            activity.startActivity(intent)
        }
    }
}
