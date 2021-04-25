package com.ryanrvldo.devhub.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserDetailsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
) : ViewModel() {

    val userDetails: LiveData<Resource<UserDetails>> by lazy {
        getUserDetailsUseCase.getUserDetails().asLiveData()
    }

}

