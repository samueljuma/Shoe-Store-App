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

    //Livedata variable fr navigating to shoeList screen
    private val _navigateToShoeList = MutableLiveData<Boolean?>()
    val navigateToShoeList: LiveData<Boolean?> =_navigateToShoeList

    /**
     * EditTextFields Data
     */
     val shoeName = MutableLiveData<String>()
     val company = MutableLiveData<String>()
     val shoeSize = MutableLiveData<String>()
     val shoeDesc = MutableLiveData<String>()

    init {
        loadListOfShoes()
    }

    //function load available list of shoes
    private fun loadListOfShoes(){
        val shoes = mutableListOf(
            Shoe("AirMax 90", "Nike","9","Classic Sneaker with visible Air cushioning."),
            Shoe("Old Skool", "Vans", "8", "Iconic skate shoe with durable construction.")
//            Shoe("Superstar", "Adidas", "9", "Iconic shell-toe design, versatile for any outfit."),
//            Shoe("Classic Leather", "Reebok", "9", "Timeless style and comfort for everyday wear.")

        )
        _listOfShoes.value = shoes
    }

    //function adds new shoe to list
    fun addShoeToList (shoe: Shoe){
        _listOfShoes.value = _listOfShoes.value?.plus(shoe)
    }

    fun onSaveClicked() {
        val newShoe = Shoe(
            shoeName.value ?: "",
            company.value ?: "",
            shoeSize.value ?: "",
            shoeDesc.value ?: ""
        )
        addShoeToList(newShoe)
        _navigateToShoeList.value = true
    }

    fun onDoneNavigatingToShoeList(){
        _navigateToShoeList.value = null
    }

}