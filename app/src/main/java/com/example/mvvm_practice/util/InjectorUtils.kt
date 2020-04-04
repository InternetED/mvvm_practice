package com.example.mvvm_practice.util

import android.app.Application
import com.example.mvvm_practice.data.*
import com.example.mvvm_practice.ui.QuotesViewModelFactory

object InjectorUtils {


    fun provideFakeQuoteDao() :QuoteDao{
        return FakeDatabase.getInstance().quotaDao
    }

    fun provideQuoteDao(application: Application): QuoteDao {
        return QuoteDatabase.getInstance(application).quoteDao()
    }

    fun provideQuotesViewModelFactory(quoteDao: QuoteDao): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

}