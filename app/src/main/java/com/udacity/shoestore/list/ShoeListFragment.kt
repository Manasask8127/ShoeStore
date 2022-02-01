package com.udacity.shoestore.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.EachShoeBinding
import com.udacity.shoestore.databinding.ShoelistFragmentBinding

import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.shoelist_fragment.*
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel

    private lateinit var binding: ShoelistFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(
            inflater, R.layout.shoelist_fragment, container, false)

        binding.shoeDetail.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        //logout menu
        setHasOptionsMenu(true)

        shoeViewModel= ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

//        binding.shoeViewModelList =shoeViewModel
          binding.lifecycleOwner = this

        shoeViewModel.shoelist.observe(viewLifecycleOwner,Observer{
            shoeList->
            for(shoe in shoeList)
            {
                Timber.i("shoelist is ${shoeList}")
                val eachShoeBinding =EachShoeBinding.inflate(layoutInflater)
                eachShoeBinding.shoe=shoe
                binding.shoeList.addView(eachShoeBinding.root)
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}