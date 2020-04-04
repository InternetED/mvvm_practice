package com.example.mvvm_practice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(

    val quoteText: String,
    val author: String,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
) {

    override fun toString(): String {
        return "$quoteText - $author"
    }
}