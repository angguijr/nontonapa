package com.example.nontonapa.UI.Selected

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nontonapa.R
import com.example.nontonapa.utilities.StaticData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_selected_film.*

class SelectedFilmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(StaticData.thumbnail)
            .into(thumb_selected)

        title_selected.text = StaticData.title
        duration_selected.text = StaticData.duration
        rating_selected.text = StaticData.rating
        genre_selected.text = StaticData.genre.toString()
        quality_selected.text = StaticData.quality

        shareBtn.setOnClickListener {
            val title = StaticData.title.toUpperCase()
            val rating = StaticData.rating
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nama Film : $title \nrating : $rating")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = SelectedFilmFragment()
    }
}