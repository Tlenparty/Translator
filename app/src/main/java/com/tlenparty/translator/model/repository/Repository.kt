package com.tlenparty.translator.model.repository

import io.reactivex.Observable

// Репозиторий представляет собой слой получения и хранения данных, которые он
// передаёт интерактору
interface Repository<T> {
   suspend fun getData(word:String): T
}