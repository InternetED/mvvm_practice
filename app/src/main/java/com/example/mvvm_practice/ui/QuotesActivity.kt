package com.example.mvvm_practice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_practice.R
import com.example.mvvm_practice.data.Quote
import com.example.mvvm_practice.util.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity(R.layout.activity_quotes) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialize()
    }

    private fun initialize() {
        val quoteDao = InjectorUtils.provideQuoteDao(this.application)
        val factory = InjectorUtils.provideQuotesViewModelFactory(quoteDao)
        val viewModel = ViewModelProvider(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer {quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
