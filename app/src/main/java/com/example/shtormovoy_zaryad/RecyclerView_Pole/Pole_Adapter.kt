package com.example.shtormovoy_zaryad.RecyclerView_Pole

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shtormovoy_zaryad.R
import kotlinx.android.synthetic.main.odno_pole_recyclerview.view.*

class Pole_Adapter(var click: OnPoleVseCklick) : RecyclerView.Adapter<Pole_Adapter.Pole_View_Holder>(){

    var fields: List<Data_Pole> = ArrayList()
    set(array) {
        field = array
        notifyDataSetChanged()
    }



    class Pole_View_Holder(val view: View): RecyclerView.ViewHolder(view) {
         fun initialize(item: Data_Pole, action: OnPoleVseCklick) {
             itemView.setOnClickListener() {
                 action.onPoleClick(item, adapterPosition)
             }
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pole_View_Holder {
        return Pole_View_Holder(LayoutInflater.from(parent.context)
            .inflate(R.layout.odno_pole_recyclerview, parent, false))
    }

    override fun onBindViewHolder(holder: Pole_View_Holder, position: Int) {
        val pole = fields[position]


        holder.view.name_pole_recview.text = pole.name
        holder.view.mark_pole_recview.text = pole.mark.toString()
        holder.view.chislo_l_pole_recview.text = pole.chislo_l.toString()
        Glide.with(holder.view.context)
            .load(pole.img_url)
            .into(holder.view.image_pole_recview)

        holder.initialize(fields.get(position), click)
    }

    override fun getItemCount(): Int {
        return fields.size
    }
}

interface OnPoleVseCklick {
    fun onPoleClick(pole: Data_Pole, position: Int)
}