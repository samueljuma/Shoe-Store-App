package com.sjcreatives.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.shoestore.data.Shoe

class MyViewModel : ViewModel() {

    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes : LiveData<List<Shoe>> = _listOfShoes

    init {
        loadListOfShoes()
    }

    private fun loadListOfShoes(){
        val shoes = listOf(
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
        )
        _listOfShoes.value = shoes
    }

}