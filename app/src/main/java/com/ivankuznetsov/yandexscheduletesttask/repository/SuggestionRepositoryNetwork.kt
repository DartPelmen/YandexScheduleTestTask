package com.ivankuznetsov.yandexscheduletesttask.repository

 import android.util.Log
 import com.ivankuznetsov.yandexscheduletesttask.model.Suggestion
 import com.ivankuznetsov.yandexscheduletesttask.network.NetworkClient

 import io.ktor.client.request.get
 import io.ktor.client.statement.bodyAsText
 import io.ktor.http.URLProtocol
 import io.ktor.http.path
 import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SuggestionRepositoryNetwork : SuggestionRepository {
    override fun getAllSuggestions(part: String): Flow<List<Suggestion>> {
        return flow {
            Log.d("REPO", "PART is $part")
            val suggestions = mutableListOf<Suggestion>()
            val resp = NetworkClient.client.get{
                url{
                    protocol = URLProtocol.HTTPS
                    host = "suggests.rasp.yandex.net"
                    path("all_suggests")
                    parameters.append("format","old")
                    parameters.append("part",part)
                }
            }
            Log.d("REPO", resp.bodyAsText())
            emit(suggestions)
        }
    }
}