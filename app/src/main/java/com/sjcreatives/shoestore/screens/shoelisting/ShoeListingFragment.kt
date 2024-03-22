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
import com.sjcreatives.shoestore.databinding.FragmentShoeListingBinding

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

        val rootLayout = binding.shoeListRootView
        val shoe_item_view = layoutInflater.inflate(R.layout.shoe_item_layout, rootLayout,false)

        rootLayout.addView(shoe_item_view)

        return binding.root
    }

}