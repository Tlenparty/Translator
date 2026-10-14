package com.tlenparty.translator.interactor.history

import com.tlenparty.translator.model.data.AppState

interface IHistoryInteractor {
    suspend fun getData():AppState
}