package com.divyanshu.findyourinterest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.divyanshu.findyourinterest.R
import com.divyanshu.findyourinterest.adapter.FavouriteInterestsAdapter
import com.divyanshu.findyourinterest.databinding.FragmentFavouriteBinding
import com.divyanshu.findyourinterest.model.Interest
import com.divyanshu.findyourinterest.viewmodel.FavouriteInterestViewModel

class FavouriteFragment : Fragment(R.layout.fragment_favourite) {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var favouriteInterestsAdapter: FavouriteInterestsAdapter
    private val favouritesViewModel by activityViewModels<FavouriteInterestViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        favouriteInterestsAdapter = FavouriteInterestsAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = favouriteInterestsAdapter
        }

        favouritesViewModel.favouriteInterests.observe(viewLifecycleOwner) {
            it?.let {
                favouriteInterestsAdapter.differ.submitList(it)
                shouldShowEmptyListText(it)
            }
        }
    }

    private fun shouldShowEmptyListText(it: List<Interest>) {
        if (it.isEmpty()) {
            binding.recyclerView.visibility = View.GONE
            binding.textView3.visibility = View.VISIBLE
        } else {
            binding.recyclerView.visibility = View.VISIBLE
            binding.textView3.visibility = View.GONE
        }
    }
}