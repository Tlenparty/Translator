package com.tlenparty.translator.interactor.history

import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.model.data.DataModel
import com.tlenparty.translator.model.repository.local.RepositoryLocal

class HistoryInteractor(
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : IHistoryInteractor{

   /* override suspend fun getData(word: String, isRemoteSource: Boolean): AppState {
        val repo = if (isRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }
        return AppState.Success(repo.getData(word))
    }*/

    override suspend fun getData(): AppState {
        return AppState.Success(repositoryLocal.getData(""))
    }
}