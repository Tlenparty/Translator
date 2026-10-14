package com.tlenparty.translator.model.repository.local

import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.model.repository.Repository

interface RepositoryLocal<T>:Repository<T> {

    suspend fun saveData(appState: AppState)
}