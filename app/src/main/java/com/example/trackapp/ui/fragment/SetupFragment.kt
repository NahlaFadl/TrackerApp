package com.example.trackapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trackapp.R
import com.example.trackapp.databinding.FragmentRunBinding
import com.example.trackapp.databinding.FragmentSetupBinding

class SetupFragment : Fragment(R.layout.fragment_setup) {
//    private lateinit var dataBinding: FragmentSetupBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dataBinding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_setup)
//        dataBinding.lifecycleOwner = this

    val tvContinue=view.findViewById<TextView>(R.id.tvContinue)
        tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        }
    }
}