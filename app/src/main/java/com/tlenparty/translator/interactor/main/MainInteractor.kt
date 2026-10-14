package com.tlenparty.translator.interactor.main

import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.model.data.DataModel
import com.tlenparty.translator.model.repository.Repository
import com.tlenparty.translator.model.repository.local.RepositoryLocal

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    // Интерактор лишь запрашивает у репозитория данные, детали имплементации ему не известны
    override suspend fun getData(word: String, isRemoteSource: Boolean): AppState {
        return if (isRemoteSource) {
            val data = remoteRepository.getData(word)
            val appState = AppState.Success(data)
            localRepository.saveData(appState)
            appState
        } else {
            val data = localRepository.getData(word)
            AppState.Success(data)
        }
    }
}