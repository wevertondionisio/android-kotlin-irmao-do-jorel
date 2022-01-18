package com.example.irmaodojorel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.irmaodojorel.R
import com.example.irmaodojorel.data.model.Episodios
import kotlinx.android.synthetic.main.item_list_episodio.view.*

class EpisodioAdapter (private val episodios: List<Episodios>) : RecyclerView.Adapter<EpisodioAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_episodio, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount() = episodios.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val episodios = episodios[position]

        holder.nome.text = episodios.nome
        holder.descricao.text = episodios.descricao
        holder.sinopse.text = episodios.sinopse
        holder.temporada.text = episodios.temporadaId.toString()
        holder.dataEstreia.text = episodios.dataEstreia.toString()

        if(episodios.links.isNullOrEmpty()) {
            holder.fonte.tvFontText.visibility = View.GONE
            holder.urlImage.ivImageUrl.visibility = View.GONE
        } else {
            holder.fonte.text = episodios.links.get(0).fonte
            holder.urlImage.text = episodios.links.get(0).url
        }
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.tvNameText
        val descricao: TextView = view.tvDescriptionText
        val sinopse: TextView = view.tvSynopsisText
        val temporada: TextView = view.tvSeasonText
        val dataEstreia: TextView = view.tvDateText
        val fonte: TextView = view.tvFontText
        val urlImage: TextView = view.ivImageUrl
    }

}