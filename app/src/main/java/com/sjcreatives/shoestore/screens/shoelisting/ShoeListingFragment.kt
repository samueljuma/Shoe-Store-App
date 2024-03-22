package com.sjcreatives.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sjcreatives.shoestore.MyViewModel
import com.sjcreatives.shoestore.data.Shoe
import com.sjcreatives.shoestore.databinding.FragmentShoeListingBinding
import com.sjcreatives.shoestore.databinding.ShoeItemLayoutBinding

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding

    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeListingBinding.inflate(layoutInflater, container,false)

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        binding.addFAB.setOnClickListener {
            findNavController().navigate(
                ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment()
            )
        }
        //Observe livedata for list of shoes and display
        myViewModel.listOfShoes.observe(viewLifecycleOwner){shoes ->
            shoes?.let {
                displayShoes(shoes)
            }
        }

        val shoe = Shoe("AirMax 90", "Nike", 9,"Classic sneaker with visible Air cushioning, perfect for casual wear.")
        myViewModel.addShoeToList(shoe)


        return binding.root
    }

    //This function displays list of shoes in the list given
    private fun displayShoes(shoes: List<Shoe>){
        val rootLayout = binding.shoeListRootView

        for (shoe in shoes){
            val shoeItemBinding = ShoeItemLayoutBinding.inflate(layoutInflater, rootLayout, false)
            shoeItemBinding.shoe = shoe
            rootLayout.addView(shoeItemBinding.root)
        }
    }

}