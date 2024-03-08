package com.divyanshu.findyourinterest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyanshu.findyourinterest.model.Interest
import com.divyanshu.findyourinterest.model.Result
import com.divyanshu.findyourinterest.repository.InterestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestViewModel @Inject constructor(private val repository: InterestRepository) :
    ViewModel() {

    private val _interestResponse = MutableLiveData<Result<Interest>>()
    val interest: LiveData<Result<Interest>> get() = _interestResponse
    private val _shouldNavigate = MutableLiveData<Boolean>()
    val shouldNavigate: LiveData<Boolean> get() = _shouldNavigate

    init {
        getAnInterest()
    }

    fun getAnInterest() {
        _interestResponse.postValue(Result.Loading)
        viewModelScope.launch {
            repository.getRandomInterest().let {
                if (it.isSuccessful) {
                    _interestResponse.postValue(Result.Success(it.body()))
                } else {
                    _interestResponse.postValue(Result.Error(it.message(), it.code()))
                }
            }
        }
    }

    fun navigateToInterestsTab(shouldNavigate: Boolean) {
        _shouldNavigate.postValue(shouldNavigate)
    }

}