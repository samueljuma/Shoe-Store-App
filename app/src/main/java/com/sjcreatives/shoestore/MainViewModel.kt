package com.sjcreatives.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.shoestore.data.Shoe

class MainViewModel : ViewModel(){

    init {
        loadListOfShoes()
    }

    private val _list_of_shoes = MutableLiveData<List<Shoe>>()

    val list_of_shoes: LiveData<List<Shoe>> = _list_of_shoes

    private fun loadListOfShoes(){
       val shoeList = listOf(
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear.")
        )
        _list_of_shoes.value = shoeList
    }


}