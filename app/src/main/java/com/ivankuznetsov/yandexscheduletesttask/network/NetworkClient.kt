package com.ivankuznetsov.yandexscheduletesttask.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object NetworkClient {
    val client = HttpClient(){
        install(ContentNegotiation) {
            json()
        }
    }
}