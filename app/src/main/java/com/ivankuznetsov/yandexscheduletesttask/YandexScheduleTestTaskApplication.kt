package com.ivankuznetsov.yandexscheduletesttask

import android.app.Application
import com.ivankuznetsov.yandexscheduletesttask.repository.SuggestionRepository
import com.ivankuznetsov.yandexscheduletesttask.repository.SuggestionRepositoryNetwork
import com.ivankuznetsov.yandexscheduletesttask.viewmodel.SuggestionViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

val sliderModule = module {
    single<SuggestionRepository> {
        SuggestionRepositoryNetwork()
    }
    viewModel { SuggestionViewModel(get()) }
}

class YandexScheduleTestTaskApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@YandexScheduleTestTaskApplication)
            modules(sliderModule)
        }
    }
}