package com.divyanshu.findyourinterest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.divyanshu.findyourinterest.model.Interest
import com.divyanshu.findyourinterest.repository.FavouriteInterestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteInterestViewModel @Inject constructor(private val repository: FavouriteInterestRepository) :
    ViewModel() {

    val favouriteInterests: LiveData<List<Interest>> = repository.allInterest.asLiveData()

    fun addToFavorites(interest: Interest) =
        viewModelScope.launch {
            repository.insertFavouriteInterest(interest)
        }

    fun deleteFromFavorites(interest: Interest) =
        viewModelScope.launch {
            repository.deleteInterest(interest)
        }

}