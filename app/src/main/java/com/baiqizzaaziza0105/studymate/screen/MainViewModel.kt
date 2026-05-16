package com.baiqizzaaziza0105.studymate.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baiqizzaaziza0105.studymate.database.TugasDao
import com.baiqizzaaziza0105.studymate.model.Tugas
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: TugasDao) : ViewModel() {

    val data: StateFlow<List<Tugas>> =
        dao.getTugas().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    val deletedData: StateFlow<List<Tugas>> =
        dao.getDeletedTugas().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
}