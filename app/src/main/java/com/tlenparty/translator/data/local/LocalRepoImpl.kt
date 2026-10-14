package com.tlenparty.translator.data.local

import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.model.data.DataModel
import com.tlenparty.translator.model.datasource.DataSource
import com.tlenparty.translator.model.datasource.local.DataSourceLocal
import com.tlenparty.translator.model.repository.local.RepositoryLocal

class LocalRepoImpl(
    private val dataSource: DataSourceLocal<List<DataModel>>,
):RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveData(appState: AppState) {
        dataSource.saveData(appState)
    }
}