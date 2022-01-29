package com.udacity.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailFragmentBinding


class ShoeDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: ShoedetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoedetail_fragment, container, false)



        return binding.root
    }
}