package com.example.nontonapa.UI.Home

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.nontonapa.Adapter.HomeAdapter
import com.example.nontonapa.DataFilm
import com.example.nontonapa.Network.RetrofitClient
import com.example.nontonapa.film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    init {
        Log.d("HomeViewModel", "Created")
    }

    var listFilm : ArrayList<film> = arrayListOf()

    interface onClickListener {
        fun onClick(film: film)
    }

    fun getDataFromApi(recyclerView: RecyclerView, progressBar: ProgressBar, listener: onClickListener) {

        RetrofitClient.instance.getDataFilm().enqueue(object : Callback<DataFilm> {
            override fun onResponse(call: Call<DataFilm>, response: Response<DataFilm>) {
                Log.d("HomeViewModel", "Request")
                val data = response.body()?.result
                listFilm.addAll(data as ArrayList<film>)
                recyclerView.adapter = HomeAdapter(data as ArrayList<film>, object : HomeAdapter.OnItemClickListener {
                    override fun onClick(film: film) {
                        listener.onClick(film)
                    }

                })
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<DataFilm>, t: Throwable) {
                Log.d("HomeViewModel", "onFailure")
            }

        })

    }

}