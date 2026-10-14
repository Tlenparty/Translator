package com.tlenparty.translator.ui.history

import android.util.Log
import androidx.lifecycle.LiveData
import com.tlenparty.translator.interactor.history.HistoryInteractor
import com.tlenparty.translator.interactor.history.IHistoryInteractor
import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.ui.base.BaseViewModel
import kotlinx.coroutines.*

class HistoryViewModel(
    private val interactor: IHistoryInteractor,
) : BaseViewModel<AppState>() {

    private val viewModelScope = CoroutineScope(
         Dispatchers.Main +
                SupervisorJob() + CoroutineExceptionHandler { _, throwable ->
            Log.e(HistoryViewModel::class.java.simpleName, "error", throwable)
        }
    )

    init {
         getData()
    }

    fun getData() {
        stateLiveData.value = AppState.Loading(null)
        viewModelScope.coroutineContext.cancelChildren()
        // Запускаем запрос данных из интерактора
        viewModelScope.launch {
            val data = interactor.getData()
            stateLiveData.value = data
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.coroutineContext.cancelChildren()
    }
}