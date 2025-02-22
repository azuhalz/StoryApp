package com.example.storyapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storyapp.data.repository.StoryRepository
import kotlinx.coroutines.launch

class SettingViewModel(private val repository: StoryRepository) : ViewModel() {

    fun logout() = viewModelScope.launch { repository.deleteUser() }

}