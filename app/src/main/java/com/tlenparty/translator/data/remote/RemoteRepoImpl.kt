package com.tlenparty.translator.data.remote

import com.tlenparty.translator.model.data.DataModel
import com.tlenparty.translator.model.datasource.DataSource
import com.tlenparty.translator.model.repository.Repository

class RemoteRepoImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = dataSource.getData(word)
}