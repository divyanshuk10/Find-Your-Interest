package com.divyanshu.findyourinterest.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.divyanshu.findyourinterest.R
import com.divyanshu.findyourinterest.databinding.FragmentInterestsBinding
import com.divyanshu.findyourinterest.ui.InterestViewModel

class InterestsFragment : Fragment(R.layout.fragment_interests) {

    private var _binding: FragmentInterestsBinding? = null
    private val binding get() = _binding!!
    private val interestViewModel by activityViewModels<InterestViewModel>()

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interestViewModel.getAnInterest()
        interestViewModel.interest.observe(requireActivity(), Observer {
            Log.d("TAG", it.toData().toString())
        })
    }

}