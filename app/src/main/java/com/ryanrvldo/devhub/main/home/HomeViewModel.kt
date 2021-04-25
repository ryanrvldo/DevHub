package com.ryanrvldo.devhub.main.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserReceivedEventsUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: GetUserReceivedEventsUseCase,
) : ViewModel() {

    private val _username = MutableLiveData<String>()
    fun setUsernameValue(name: String) {
        _username.value = name
    }

    val events: LiveData<PagingData<ReceivedEvents>> by lazy {
        Transformations.switchMap(_username) {
            useCase.getEvents(it)
                .cachedIn(viewModelScope)
                .asLiveData()
        }
    }

}
