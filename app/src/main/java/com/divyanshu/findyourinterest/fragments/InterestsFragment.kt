package com.divyanshu.findyourinterest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.divyanshu.findyourinterest.R
import com.divyanshu.findyourinterest.databinding.FragmentInterestsBinding
import com.divyanshu.findyourinterest.model.Result
import com.divyanshu.findyourinterest.ui.InterestViewModel
import com.divyanshu.findyourinterest.utils.Constant.Companion.hobbiesList

class InterestsFragment : Fragment(R.layout.fragment_interests) {

    private var _binding: FragmentInterestsBinding? = null
    private val binding get() = _binding!!
    private val interestViewModel by activityViewModels<InterestViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentInterestsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgHobby.load(hobbiesList[(0..9).random()])
        findNewInterest()

        binding.swipeRefresh.setOnRefreshListener {
            findNewInterest()
        }

        interestViewModel.interest.observe(requireActivity()) {
            when (it) {
                is Result.Loading -> {
                    showProgress()
                }

                is Result.Error -> {
                    hideProgress()
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                is Result.Success -> {
                    hideProgress()
                    it.toData()?.let { interest ->
                        binding.txtActivity.text =
                            buildString {
                                append(context?.resources?.getString(R.string.activity))
                                append(interest.activity)
                            }
                        binding.txtParticipants.text =
                            buildString {
                                append(context?.resources?.getString(R.string.participants))
                                append(interest.participants)
                            }
                        binding.txtType.text =
                            buildString {
                                append(context?.resources?.getString(R.string.type))
                                append(interest.type)
                            }
                        binding.txtLink.text =
                            buildString {
                                append(context?.resources?.getString(R.string.link))
                                append(interest.link)
                            }
                        binding.txtAccessibility.text =
                            buildString {
                                append(context?.resources?.getString(R.string.accessibility))
                                append(interest.accessibility)
                            }
                    }
                }
            }
        }
    }

    private fun findNewInterest() {
        interestViewModel.getAnInterest()
    }

    private fun hideProgress() {
        binding.swipeRefresh.isRefreshing = false
    }

    private fun showProgress() {
        binding.swipeRefresh.isRefreshing = true
    }
}