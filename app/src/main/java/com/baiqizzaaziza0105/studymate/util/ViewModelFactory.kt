package com.baiqizzaaziza0105.studymate.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baiqizzaaziza0105.studymate.database.TugasDb
import com.baiqizzaaziza0105.studymate.screen.DetailViewModel
import com.baiqizzaaziza0105.studymate.screen.MainViewModel

class ViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = TugasDb.getInstance(context).dao

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}