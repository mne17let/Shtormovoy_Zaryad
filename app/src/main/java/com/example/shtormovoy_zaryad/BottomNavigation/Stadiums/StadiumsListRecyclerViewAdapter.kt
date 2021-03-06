package com.example.shtormovoy_zaryad.BottomNavigation.Stadiums

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.MainActivity
import com.example.shtormovoy_zaryad.DataBase.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.R

class StadiumsListRecyclerViewAdapter: RecyclerView.Adapter<StadiumsListRecyclerViewAdapter.ViewHolderStadium>() {

    lateinit var arrayOfStadiums: ArrayList<StadiumModel>

    fun setList(list: ArrayList<StadiumModel>) {

        // Устанавливаю список в адаптер для отображения полей из него
        arrayOfStadiums = list
        notifyDataSetChanged()
    }

    class ViewHolderStadium(view: View): RecyclerView.ViewHolder(view) {

        // Инициализирую переменные, при помощи которых получаю доступ к View на экране

        var textMark: TextView = view.findViewById(R.id.stadiums_list_one_stadium_mark_text_id)
        var textCount: TextView = view.findViewById(R.id.stadiums_list_one_stadium_number_of_people_text_id)
        var textName: TextView = view.findViewById(R.id.stadiums_list_one_stadium_name_id)
        var mark: TextView = view.findViewById(R.id.stadiums_list_one_stadium_mark_id)
        var numberOfPeople: TextView = view.findViewById(R.id.stadiums_list_one_stadium_number_of_people_id)
        var photoStadium: ImageView = view.findViewById(R.id.stadiums_list_one_stadium_photo_id)


        fun bind(one_stadium: StadiumModel) {

            // Данный метод выполняется во время привязки (периспользования) одной карточки RecyclerView
            textMark.setText(R.string.textForMarkTextView)
            textCount.setText(R.string.textForCountPeopleTextView)
            textName.text = one_stadium.stadiumName
            mark.text = one_stadium.mark.toString()
            numberOfPeople.text = one_stadium.countPeople.toString()
            photoStadium.setImageResource(R.drawable.photo_pole)
            this.itemView.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    //Log.d("VLADIMIR", "${one_stadium.stadiumId} в RecViewAdapter при передаче в MainActivity")
                    MainActivity.mainActivity.showOneStadiumFragment(one_stadium.stadiumId)
                }

            })
        }
    }

    override fun onCreateViewHolder(viewGroupForInflating: ViewGroup, viewType: Int): ViewHolderStadium {
        // "Надуваю" XML-макет
        val inflatedView = LayoutInflater.from(viewGroupForInflating.context)
            .inflate(R.layout.stadiumslist_one_stadium_layout, viewGroupForInflating, false)

        // Создаю класс-холдер, который будет внутри устанавливать "надутый" XML-макет, который и передаю в конструктор
        val viewHolderStadiumObject = ViewHolderStadium(inflatedView)

        return viewHolderStadiumObject
    }

    override fun onBindViewHolder(viewHolderStadiumObject: ViewHolderStadium, position: Int) {
        // Вызываю метод, который необходимо выполнить во время привязки (периспользования) одной карточки RecyclerView
        viewHolderStadiumObject.bind(arrayOfStadiums[position])
    }

    override fun getItemCount(): Int {
        // Возвращаю размер списка полей
        return arrayOfStadiums.size
    }

}

