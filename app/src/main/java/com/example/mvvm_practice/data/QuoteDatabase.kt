package com.example.mvvm_practice.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Quote::class])
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao


    companion object {
        @Volatile
        private var db: QuoteDatabase? = null

        fun getInstance(application: Application) =
            db ?: synchronized(this) {
                db ?: Room.databaseBuilder(
                    application,
                    QuoteDatabase::class.java,
                    "database-name"
                )
                    .allowMainThreadQueries()
                    .build().also {
                        db = it
                    }
            }
    }
}