package com.example.irmaodojorel.ui.fragments

import android.content.ContentValues.TAG
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.irmaodojorel.R
import com.example.irmaodojorel.adapter.PersonagemAdapter
import com.example.irmaodojorel.data.api.RetrofitPersonagem
import com.example.irmaodojorel.data.model.Personagem
import com.example.irmaodojorel.util.Resource
import kotlinx.android.synthetic.main.fragment_personagem.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonagemFragment : Fragment(R.layout.fragment_personagem),
    PersonagemAdapter.OnItemClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callService()
    }

    fun callService(){
        val result: Call<List<Personagem>> = RetrofitPersonagem.api.listPersonagens()

        result.enqueue(object : Callback<List<Personagem>> {

            override fun onFailure(call: Call<List<Personagem>>, t: Throwable) {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Personagem>>, response: Response<List<Personagem>>) {
                Toast.makeText(activity, "Irmão do Borel", Toast.LENGTH_SHORT).show()
                showData(response.body()!!)
            }
        })
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun showData(personagem: List<Personagem>) {
        rvList.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = PersonagemAdapter(personagem, this@PersonagemFragment)
        }
    }

    override fun onItemClick(personagem: Personagem) {
        Toast.makeText(activity, "Personagem ${personagem.nome}", Toast.LENGTH_SHORT).show()

            val action = PersonagemFragmentDirections.actionPersonagemFragmentToDescriptionFragment(personagem)
        findNavController().navigate(action)
    }
}