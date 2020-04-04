package com.example.mvvm_practice.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuotes():LiveData<List<Quote>>

    @Insert
    fun addQuote(quote: Quote)

    @Delete
    fun deleteQuote(quote: Quote)
}