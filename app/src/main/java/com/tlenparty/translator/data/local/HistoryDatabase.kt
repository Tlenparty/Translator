package com.tlenparty.translator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tlenparty.translator.data.local.model.HistoryEntity

@Database(
    entities = [HistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HistoryDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}