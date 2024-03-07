package com.divyanshu.findyourinterest.ui

import androidx.lifecycle.ViewModel
import com.divyanshu.findyourinterest.repository.FavouriteInterestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteInterestViewModel @Inject constructor(private val repository: FavouriteInterestRepository) :
    ViewModel() {

}