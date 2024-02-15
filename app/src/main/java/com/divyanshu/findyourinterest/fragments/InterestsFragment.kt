package com.divyanshu.findyourinterest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.divyanshu.findyourinterest.R
import com.divyanshu.findyourinterest.databinding.FragmentInterestDetailsBinding
import com.divyanshu.findyourinterest.databinding.FragmentInterestsBinding

class InterestsFragment : Fragment(R.layout.fragment_interests) {

    private var _binding: FragmentInterestsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // TODO : fetch args
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentInterestsBinding.inflate(inflater, container, false)
        return binding.root
    }

}