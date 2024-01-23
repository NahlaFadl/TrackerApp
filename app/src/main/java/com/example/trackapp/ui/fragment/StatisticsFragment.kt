package com.example.trackapp.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.trackapp.R
import com.example.trackapp.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistic) {

    private val viewModel: StatisticsViewModel by viewModels()
}