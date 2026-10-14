package com.tlenparty.translator

import android.app.Application
import com.tlenparty.translator.di.application
import com.tlenparty.translator.di.historyScreen
import com.tlenparty.translator.di. mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}