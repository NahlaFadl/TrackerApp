package com.example.trackapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.trackapp.db.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {
}