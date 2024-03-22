package com.sjcreatives.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.sjcreatives.shoestore.MyViewModel
import com.sjcreatives.shoestore.R
import com.sjcreatives.shoestore.data.Shoe
import com.sjcreatives.shoestore.databinding.FragmentShoeListingBinding
import com.sjcreatives.shoestore.databinding.ShoeItemLayoutBinding

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding

    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeListingBinding.inflate(layoutInflater, container,false)

      //  setHasOptionsMenu(true) // This is Deprecated as of 3/23/2024

        // Handle FAB click events
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

        /**
         * This code handles the Manu Item click
         */
        val menuProvider = object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.shoe_list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(menuItem, requireView().findNavController())
            }

        }
        requireActivity().addMenuProvider(menuProvider,viewLifecycleOwner, Lifecycle.State.RESUMED)
        //-----------------------------------------------------------------------------------------------


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