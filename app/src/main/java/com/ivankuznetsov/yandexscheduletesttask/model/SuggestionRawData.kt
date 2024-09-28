package com.ivankuznetsov.yandexscheduletesttask.model

import kotlinx.serialization.Serializable

@Serializable
data class SuggestionRawData(val data: List<List<List<String>?>?>)