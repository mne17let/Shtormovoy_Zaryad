package com.example.shtormovoy_zaryad.ui.StadiumsFragmentRecyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.Model.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.R

class StadiumsFragmentRecyclerViewAdapter: RecyclerView.Adapter<StadiumsFragmentRecyclerViewAdapter.ViewHolderStadium>() {

    lateinit var arrayOfStadiums: ArrayList<StadiumModel>

    fun setList(list: ArrayList<StadiumModel>) {
        arrayOfStadiums = list
        notifyDataSetChanged()
    }

    class ViewHolderStadium(view: View): RecyclerView.ViewHolder(view) {
        var textMark: TextView = view.findViewById(R.id.id_mark_text_stadium_recyclerview)
        var textCount: TextView = view.findViewById(R.id.id_countpeople_text_stadium_recyclerview)
        var textName: TextView = view.findViewById(R.id.id_name_stadium_recyclerview)
        var mark: TextView = view.findViewById(R.id.id_mark_stadium_recyclerview)
        var countPeople: TextView = view.findViewById(R.id.id_countpeople_stadium_recyclerview)
        var photoStadium: ImageView = view.findViewById(R.id.id_photo_stadium_recyclerview)


        fun bind(one_stadium: StadiumModel) {
            textMark.setText(R.string.textForMarkTextView)
            textCount.setText(R.string.textForCountPeopleTextView)
            textName.text = one_stadium.stadiumName
            mark.text = one_stadium.mark.toString()
            countPeople.text = one_stadium.countPeople.toString()
            photoStadium.setImageResource(R.drawable.photo_pole)
        }
    }

    override fun onCreateViewHolder(viewGroupForInflating: ViewGroup, viewType: Int): ViewHolderStadium {
        val inflatedView = LayoutInflater.from(viewGroupForInflating.context)
            .inflate(R.layout.layout_for_one_stadium_recycler_view, viewGroupForInflating, false)

        val viewHolderStadiumOnj = ViewHolderStadium(inflatedView)

        return viewHolderStadiumOnj
    }

    override fun onBindViewHolder(viewHolderStadiumObject: ViewHolderStadium, position: Int) {
        viewHolderStadiumObject.bind(arrayOfStadiums[position])
    }

    override fun getItemCount(): Int {
        return arrayOfStadiums.size
    }
}