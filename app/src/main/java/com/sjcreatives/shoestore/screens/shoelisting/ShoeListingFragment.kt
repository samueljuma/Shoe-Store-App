package com.sjcreatives.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sjcreatives.shoestore.R
import com.sjcreatives.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeListingBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

}