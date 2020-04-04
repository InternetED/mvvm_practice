package com.example.mvvm_practice.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao : QuoteDao {

    private val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList;
    }


    override fun addQuote(quote: Quote) {

        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes() = quotes as LiveData<List<Quote>>

    override fun deleteQuote(quote: Quote) {
        quoteList.remove(quote)
        quotes.value = quoteList
    }
}