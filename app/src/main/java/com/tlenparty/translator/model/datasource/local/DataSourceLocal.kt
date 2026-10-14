package com.tlenparty.translator.model.datasource.local

import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.model.datasource.DataSource

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveData(appState: AppState)
}