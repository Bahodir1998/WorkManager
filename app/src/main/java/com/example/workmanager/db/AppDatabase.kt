package com.example.workmanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Currency::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

    companion object {

        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context:Context): AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"currency_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}