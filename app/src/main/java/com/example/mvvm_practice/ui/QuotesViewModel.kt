package com.example.mvvm_practice.ui

import androidx.lifecycle.ViewModel
import com.example.mvvm_practice.data.Quote
import com.example.mvvm_practice.data.QuoteRepository

class QuotesViewModel (private val quoteRepository: QuoteRepository)
    : ViewModel(){


    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}