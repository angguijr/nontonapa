package com.example.nontonapa.UI.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nontonapa.Adapter.HomeAdapter
import com.example.nontonapa.R
import com.example.nontonapa.UI.Selected.SelectedFilmFragment
import com.example.nontonapa.film
import com.example.nontonapa.utilities.StaticData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeFragment", "onCreate Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("HomeFragment", "onCreateView Called")
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "onViewCreated Called")

        recyview_home.setHasFixedSize(true)
        recyview_home.layoutManager = LinearLayoutManager(context)

        if(viewModel.listFilm.size == 0) {
            viewModel.getDataFromApi(recyview_home,progressBar , object : HomeViewModel.onClickListener {
                override fun onClick(film: film) {
                    //pindah fragment
                    StaticData.fill(film)
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.container_fragment, SelectedFilmFragment())
                        ?.addToBackStack(null)
                        ?.commit()
                }

            })
        } else {
            Log.d("HomeFragment", "List not empty")
            recyview_home.adapter = HomeAdapter(viewModel.listFilm, object : HomeAdapter.OnItemClickListener {
                override fun onClick(film: film) {
                    StaticData.fill(film)
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.container_fragment, SelectedFilmFragment())
                        ?.addToBackStack(null)
                        ?.commit()
                }
            })
            progressBar.visibility = View.GONE
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeFragment", "onDestroy Called")
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}