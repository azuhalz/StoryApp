package com.example.storyapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.storyapp.data.local.User
import com.example.storyapp.data.repository.StoryRepository
import com.example.storyapp.helper.Event
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: StoryRepository
) : ViewModel() {

    private val mIsAnimate = MutableLiveData<Event<Boolean>>()
    val isAnimate: LiveData<Event<Boolean>> = mIsAnimate

    init {
        mIsAnimate.value = Event(false)
    }

    fun login(email: String, password: String) = repository.login(email, password).asLiveData()

    fun saveUser(user: User) = viewModelScope.launch { repository.saveUser(user) }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}