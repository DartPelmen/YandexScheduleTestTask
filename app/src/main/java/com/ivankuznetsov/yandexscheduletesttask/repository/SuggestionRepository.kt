package com.ivankuznetsov.yandexscheduletesttask.repository

import com.ivankuznetsov.yandexscheduletesttask.model.Suggestion
import kotlinx.coroutines.flow.Flow

interface SuggestionRepository {
    fun getAllSuggestions(part: String): Flow<List<Suggestion>>
}