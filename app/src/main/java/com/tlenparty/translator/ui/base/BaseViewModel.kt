package com.tlenparty.translator.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tlenparty.translator.model.data.AppState
import com.tlenparty.translator.rx.ISchedulerProvider
import com.tlenparty.translator.rx.SchedulerProvider

abstract class BaseViewModel<T : AppState>(
    protected val stateLiveData: MutableLiveData<T> = MutableLiveData(),
    protected val schedulerProvider: ISchedulerProvider = SchedulerProvider()
) : ViewModel() {

    fun getStateLiveData(): LiveData<T> = stateLiveData

    override fun onCleared() {
    }

}