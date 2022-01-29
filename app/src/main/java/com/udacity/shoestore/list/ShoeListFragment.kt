package com.udacity.shoestore.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding


class ShoeListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: ShoelistFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoelist_fragment, container, false)

        binding.shoeDetail.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }




        return binding.root
    }
}