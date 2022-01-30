package com.udacity.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel

    private lateinit var binding: ShoedetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoedetail_fragment, container, false)

        shoeViewModel  =ViewModelProvider(this).get(ShoeViewModel::class.java)

        Timber.i("called detail fragment !!!")

        binding.shoeViewModel =shoeViewModel
        binding.setLifecycleOwner(this)

        binding.newShoe = Shoe("","","","")

        binding.btCancel.setOnClickListener {
           navigateTo()
        }

        shoeViewModel.dataSaved.observe(viewLifecycleOwner, Observer { isdataSaved ->
            if(isdataSaved)
            {
                navigateTo()
                shoeViewModel.onSaveFinished()
            }
        })

//        binding.btSave.setOnClickListener {
//            Timber.i("Added shoe to list")
//            navigateTo()
////               val name=binding.evShoeName.text.toString()
////               val company=binding.evShoeCompany.text.toString()
////               val size=binding.evShoeSize.text.toString()
////               val description=binding.evShoeDescription.text.toString()
////
////            if(name.equals("") || company.equals("") || size.equals("") || description.equals(""))
////            {
////                Toast.makeText(activity,"Please enter all the feilds",Toast.LENGTH_SHORT).show()
////            }
//            //else {
//                //Timber.i("shoe list in detail ${name}")
//                //shoeViewModel.addShoe(Shoe(name, company, size, description))
//
//            //}
//
//        }

        return binding.root
    }

    private fun navigateTo()
    {
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoedetailDestinationToShoelistDestination())
    }
}