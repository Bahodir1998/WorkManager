package com.example.workmanager.db

import androidx.room.*

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency")
    fun getAll(): List<Currency>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(currency: Currency)

    @Update
    fun updateAll(currency: Currency)

}