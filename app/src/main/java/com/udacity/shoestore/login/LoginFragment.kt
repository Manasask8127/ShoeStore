package com.udacity.shoestore.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)

        binding.btSignin.setOnClickListener {
            checkDataAndNavigate()
        }
        binding.btSignup.setOnClickListener {
            checkDataAndNavigate()
        }

        return binding.root
    }
    private fun checkDataAndNavigate()
    {
        if(TextUtils.isEmpty(binding.mailAddress.text) || TextUtils.isEmpty(binding.password.text))
            Toast.makeText(requireActivity(),"Please enter mail and password",Toast.LENGTH_LONG).show()
        else
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                binding.mailAddress.text.toString()
            ))
    }
}