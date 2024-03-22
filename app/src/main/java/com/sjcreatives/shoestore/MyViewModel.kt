package com.sjcreatives.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.shoestore.data.Shoe

class MyViewModel : ViewModel() {

    //livedata for the list of shoes
    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes : LiveData<List<Shoe>> = _listOfShoes

    // livedata for new shoe to be added to list
    private val _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe> = _shoe

    init {
        loadListOfShoes()
    }

    //function load available list of shoes
    private fun loadListOfShoes(){
        val shoes = mutableListOf(
            Shoe("AirMax 90", "Nike","9","Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", "9","Classic sneaker with visible Air cushioning, perfect for casual wear.")
        )
        _listOfShoes.value = shoes
    }

    //function adds new shoe to list
    fun addShoeToList (shoe: Shoe){
        _listOfShoes.value = _listOfShoes.value?.plus(shoe)
    }

}