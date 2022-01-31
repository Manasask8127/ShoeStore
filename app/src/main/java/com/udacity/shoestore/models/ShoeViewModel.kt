package com.udacity.shoestore.models

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel: ViewModel() {
    private val _shoelist= MutableLiveData<MutableList<Shoe>>()
    val shoelist: LiveData<MutableList<Shoe>>
     get() = _shoelist

    private val _dataSaved= MutableLiveData<Boolean>()
    val dataSaved : LiveData<Boolean>
    get() = _dataSaved


    init {

       _shoelist.value= mutableListOf(
           Shoe("Jordan","Nike","5","casuals")
       )

        _dataSaved.value=false
    }

    fun addShoe( newShoe: Shoe)
    {
        if(newShoe.name.equals("") || newShoe.company.equals("")
            || newShoe.size.equals("") || newShoe.description.equals(""))
        {
            _dataSaved.value=false
        }
        else {
            _shoelist.value?.add(newShoe)
            Timber.i("shoelist in model ${_shoelist.value}")
            _dataSaved.value = true
        }
    }

    fun onSaveFinished()
    {
        _dataSaved.value=false
    }
}