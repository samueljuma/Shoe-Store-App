package com.sjcreatives.shoestore.data

data class Shoe(
    /**
     * Using var (mutable) helps in two-way data binding
     */
    var shoeName: String, // Name of the shoe
    var company: String, // The shoe Company
    var size: String, // Size of the shoe
    var desc: String // A short description of the shoe
)
