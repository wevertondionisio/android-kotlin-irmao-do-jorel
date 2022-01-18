package com.example.irmaodojorel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.irmaodojorel.R
import com.example.irmaodojorel.data.model.Personagem
import kotlinx.android.synthetic.main.item_list_description.view.*
import kotlinx.android.synthetic.main.item_list_episodio.view.*
import kotlinx.android.synthetic.main.item_list_personagem.view.*
import kotlinx.android.synthetic.main.item_list_personagem.view.ivImageUrl
import kotlinx.android.synthetic.main.item_list_personagem.view.tvNameText

class PersonagemAdapter(private val personagem: List<Personagem>,
                        private val onItemClickListener: OnItemClickListener ) : RecyclerView.Adapter<PersonagemAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_personagem, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount() = personagem.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val personagem = personagem[position]
        holder.image.apply { Glide.with(this).load(personagem.imagemUrl).into(ivImageUrl) }
        holder.nome.text = personagem.nome

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(personagem)
        }
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        val nome: TextView = view.tvNameText
        val image: ImageView = view.ivImageUrl
    }

    interface OnItemClickListener {
        fun onItemClick (personagem: Personagem)
    }
}

