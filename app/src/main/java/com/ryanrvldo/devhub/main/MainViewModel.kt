package com.ryanrvldo.devhub.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserDetailsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
) : ViewModel() {

    val userDetails by lazy {
        getUserDetailsUseCase.getUserDetails().asLiveData()
    }

}

