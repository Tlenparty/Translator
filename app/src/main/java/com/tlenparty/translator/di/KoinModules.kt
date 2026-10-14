package com.tlenparty.translator.di

import androidx.room.Room
import com.tlenparty.translator.data.local.HistoryDatabase
import com.tlenparty.translator.data.local.LocalRepoImpl
import com.tlenparty.translator.data.local.RoomDataSource
import com.tlenparty.translator.interactor.main.MainInteractor
import com.tlenparty.translator.model.data.DataModel
import com.tlenparty.translator.model.datasource.DataSource
import com.tlenparty.translator.data.remote.RetrofitImplementation
import com.tlenparty.translator.model.repository.Repository
import com.tlenparty.translator.data.remote.RemoteRepoImpl
import com.tlenparty.translator.interactor.history.HistoryInteractor
import com.tlenparty.translator.interactor.history.IHistoryInteractor
import com.tlenparty.translator.model.datasource.local.DataSourceLocal
import com.tlenparty.translator.model.repository.local.RepositoryLocal
import com.tlenparty.translator.ui.history.HistoryViewModel
import com.tlenparty.translator.ui.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

// Для удобства создадим две переменные: в одной находятся зависимости,
// используемые во всём приложении, во второй - зависимости конкретного экрана
//module { } — создание модуля или субмодуля (модуля внутри модуля). Module очень похож на модули в Dagger: это контейнер для коллекции зависимостей;

val application = module {
    // Создадим бд
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    // Напряму без обращения к бд запросить в дереве ссылочку на ДАО
    single { get<HistoryDatabase>().historyDao() }

    single<DataSource<List<DataModel>>>() { RetrofitImplementation() }
    single<Repository<List<DataModel>>>() { RemoteRepoImpl(get()) }

    single<DataSourceLocal<List<DataModel>>>() { RoomDataSource(get()) }
    single<RepositoryLocal<List<DataModel>>>() { LocalRepoImpl(get()) }
}

// Функция factory сообщает Koin, что эту зависимость нужно создавать каждый
// раз заново, что как раз подходит для Activity и её компонентов.
val mainScreen = module {
    factory { MainInteractor(get(), get()) }
    factory { MainViewModel(get()) }
}

val historyScreen = module {
    factory<IHistoryInteractor> { HistoryInteractor(get()) }
    factory { HistoryViewModel(get()) }
}