package com.ivankuznetsov.yandexscheduletesttask.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ivankuznetsov.yandexscheduletesttask.model.Suggestion
import com.ivankuznetsov.yandexscheduletesttask.repository.SuggestionRepository
import kotlinx.coroutines.flow.Flow

class SuggestionViewModel(private val  suggestionRepository: SuggestionRepository):ViewModel() {
    private var data = suggestionRepository.getAllSuggestions("")
    fun getSuggestions(part: String): Flow<List<Suggestion>> {
        Log.d("VM", "PART is $part")
        data = suggestionRepository.getAllSuggestions(part)
        return data
    }
}