package com.hanifah.latihan5.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hanifah.latihan5.customImage
import com.hanifah.latihan5.detailBuahActivity
import com.hanifah.latihan5.R
import com.hanifah.latihan5.Model.ModelBuah


class BuahAdapter(private val itemList: ArrayList<ModelBuah>,
                  private val getActivity: customImage
) :
    RecyclerView.Adapter<BuahAdapter.ModelViewHolder>() {

    // ViewHolder class
    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.gambar)
        val itemText: TextView = itemView.findViewById(R.id.nama)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_customimage, parent, false)
        return ModelViewHolder(nView)
    }

    // Return the size of your dataset
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(item.image)
        holder.itemText.text = item.deskripsi

        // Set an onClickListener to start a new activity
        holder.itemView.setOnClickListener {
            //deklarasi intent
            val intent = Intent(getActivity, detailBuahActivity::class.java)
            //baru put extra variable yang ingin dilempar
            intent.putExtra("deskripsi", itemList[position].deskripsi)
            intent.putExtra("image", itemList[position].image)
            //passed ke detail
            getActivity.startActivity(intent)
        }
    }
}