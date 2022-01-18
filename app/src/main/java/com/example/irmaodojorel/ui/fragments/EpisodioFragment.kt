package com.example.irmaodojorel.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.irmaodojorel.R
import com.example.irmaodojorel.adapter.EpisodioAdapter
import com.example.irmaodojorel.data.api.RetrofitEpisodios
import com.example.irmaodojorel.data.model.Episodios
import kotlinx.android.synthetic.main.fragment_episodios.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodioFragment : Fragment(R.layout.fragment_episodios){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callService()
    }

    private fun callService() {
        val result: Call<List<Episodios>> = RetrofitEpisodios.api.getEpisodios()

        result.enqueue(object : Callback<List<Episodios>> {
            override fun onResponse(call: Call<List<Episodios>>, response: Response<List<Episodios>> ) {
                Toast.makeText(activity, "Episódios Irmão do Borel", Toast.LENGTH_SHORT).show()
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Episodios>>, t: Throwable) {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showData(episodios: List<Episodios>) {
        rvListEpisodios.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = EpisodioAdapter(episodios)
//            layoutManager = LinearLayoutManager(activity)
//            adapter = EpisodioAdapter(episodios)
        }

    }
}