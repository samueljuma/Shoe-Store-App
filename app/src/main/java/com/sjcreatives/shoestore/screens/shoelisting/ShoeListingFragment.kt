package com.sjcreatives.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.sjcreatives.shoestore.R
import com.sjcreatives.shoestore.data.Shoe
import com.sjcreatives.shoestore.databinding.FragmentShoeListingBinding
import com.sjcreatives.shoestore.databinding.ShoeItemLayoutBinding

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeListingBinding.inflate(layoutInflater, container,false)
        binding.addFAB.setOnClickListener {
            findNavController().navigate(
                ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment()
            )
        }

        val listOfShoes = listOf(
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear."),
            Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear.")
        )

        val rootLayout = binding.shoeListRootView

            for (shoe in listOfShoes){
                val shoeItemBinding = ShoeItemLayoutBinding.inflate(layoutInflater, rootLayout, false)
                shoeItemBinding.shoe = listOfShoes[0]
                rootLayout.addView(shoeItemBinding.root)
            }

        return binding.root
    }

}