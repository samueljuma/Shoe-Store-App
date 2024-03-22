package com.sjcreatives.shoestore.screens.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sjcreatives.shoestore.MyViewModel
import com.sjcreatives.shoestore.data.Shoe
import com.sjcreatives.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.shoe.observe(viewLifecycleOwner){shoe ->
            shoe?.let {
                viewModel.addShoeToList(shoe)
            }
        }
        binding.saveBtn.setOnClickListener {
            viewModel.addShoeToList(getNewShoeDetails())
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
            )
        }

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
            )
        }
        return binding.root
    }

    private fun getNewShoeDetails(): Shoe {

        val shoeName = binding.shoeNameEditText.text.toString()
        val company = binding.companyEditText.text.toString()
        val size = binding.shoeSizeEditText.text.toString()
        val desc = binding.descEditText.text.toString()

        return Shoe(shoeName, company, size, desc)
    }

}