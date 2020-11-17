package com.ryanrvldo.devhub.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.AccessToken
import com.ryanrvldo.devhub.core.domain.usecase.login.LoginUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase,
) : ViewModel() {

    private val _accessToken = MutableLiveData<Resource<AccessToken>>()
    val accessToken: LiveData<Resource<AccessToken>> get() = _accessToken

    fun getAccessToken(code: String) {
        viewModelScope.launch {
            useCase.getUserAccessToken(code).collect {
                _accessToken.postValue(it)
            }
        }
    }

    private val _isUserLogin by lazy {
        MutableLiveData<Resource<Boolean>>().also {
            it.value = useCase.checkUserLoginStatus()
        }
    }

    val isUserLogin: LiveData<Resource<Boolean>> get() = _isUserLogin

    fun writeUserAccessToken(accessToken: String) {
        useCase.writeUserAccessToken(accessToken)
    }

}
