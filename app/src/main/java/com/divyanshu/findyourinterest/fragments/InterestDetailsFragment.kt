package com.divyanshu.findyourinterest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.divyanshu.findyourinterest.R
import com.divyanshu.findyourinterest.databinding.FragmentInterestDetailsBinding
import com.divyanshu.findyourinterest.model.Interest

class InterestDetailsFragment : Fragment(R.layout.fragment_interest_details) {

    private var _binding: FragmentInterestDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: InterestDetailsFragmentArgs by navArgs<InterestDetailsFragmentArgs>()
    private lateinit var interest: Interest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        interest = args.interest!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentInterestDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailWebView.loadUrl(interest.link)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}