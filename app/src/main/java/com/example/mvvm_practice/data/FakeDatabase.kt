package com.example.mvvm_practice.data

class FakeDatabase private constructor(){


    var quotaDao : QuoteDao = FakeQuoteDao()
        private set

    companion object{

        @Volatile private var instance : FakeDatabase? = null

        fun getInstance() =
            instance?: synchronized(this){
                instance ?: FakeDatabase().also {
                    instance = it
                }
            }
    }
}
