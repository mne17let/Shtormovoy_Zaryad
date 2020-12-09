package com.example.shtormovoy_zaryad.HelpClasses

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shtormovoy_zaryad.RecyclerView_Pole.Data_Pole
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.concurrent.fixedRateTimer

object Singleton_Pole {
    val myBase = FirebaseDatabase.getInstance().reference.child("Поля")

    val mutable_fields: MutableLiveData<List<Data_Pole>> = MutableLiveData()

    init {
        myBase.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(p0: DataSnapshot) {
                val fields_array: ArrayList<Data_Pole> = ArrayList()
                if (p0.exists()) {
                    for (i in p0.children) {
                        val pole = convertDataToPole(i)
                        if (pole != null) fields_array.add(pole)
                    }
                }

                mutable_fields.value = fields_array.sortedByDescending { it.mark }
            }

            override fun onCancelled(p0: DatabaseError) {
            }

        })
    }



    fun getLiveFields() : MutableLiveData<List<Data_Pole>> = mutable_fields

    private fun convertDataToPole (data : DataSnapshot) = data.getValue(Data_Pole::class.java)


}