package com.tlenparty.translator.data.local

import com.tlenparty.translator.data.local.model.HistoryEntity
import com.tlenparty.translator.data.local.model.toEntity
import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.model.data.DataModel
import com.tlenparty.translator.model.datasource.local.DataSourceLocal

class RoomDataSource(
    private val historyDao: HistoryDao,
) : DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return historyDao.all().map(HistoryEntity::toDomainModel)
    }

    override suspend fun saveData(appState: AppState) {
        val entity = appState.toEntity() ?: return // чтобы обойти null
        historyDao.insert(entity)
    }
}