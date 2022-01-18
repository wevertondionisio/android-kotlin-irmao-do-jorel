package com.example.irmaodojorel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.irmaodojorel.R
import com.example.irmaodojorel.data.model.Personagem
import kotlinx.android.synthetic.main.item_list_description.*
import kotlinx.android.synthetic.main.item_list_description.view.*

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private val args by navArgs<DescriptionFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.tvNameText.text = args.personagem.nome.toString()

        if (args.personagem.idade.isNullOrEmpty()) {
            tvYearText.visibility = View.GONE
            tvYEarBold.visibility = View.GONE
        } else {
            view.tvYearText.text = args.personagem.idade.toString()
        }

        if (args.personagem.descricao.isNullOrEmpty()) {
            tvDescriptionText.visibility = View.GONE
            tvDescriptionBold.visibility = View.GONE
        } else {
            view.tvDescriptionText.text = args.personagem.descricao.toString()
        }


        if (args.personagem.frase.isNullOrEmpty()) {
            tvPhraseText.visibility = View.GONE
            tvPhraseBold.visibility = View.GONE
        } else {
            view.tvPhraseText.text = args.personagem.frase.toString()
        }

        if (args.personagem.biografia.isNullOrEmpty()) {
            tvBiographyText.visibility = View.GONE
            tvBiographyBold.visibility = View.GONE
        } else {
            view.tvBiographyText.text = args.personagem.biografia.toString()
        }


        view.tvAppearanceText.text = args.personagem.aparencia.toString()
        view.tvPersonalityText.text = args.personagem.personalidade.toString()
        Glide.with(this).load(args.personagem.imagemUrl).into(ivImageUrl)

    }
}