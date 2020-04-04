package com.example.mvvm_practice.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_practice.data.QuoteRepository

class QuotesViewModelFactory (private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}