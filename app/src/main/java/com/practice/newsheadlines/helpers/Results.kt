package com.practice.newsheadlines.helpers


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

sealed class Results<out T> {

    data class Success<out T>(val value: T) : Results<T>()
    data class Failure(val throwable: Throwable) : Results<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$value]"
            is Failure -> "Throwable[throwable=$throwable]"
        }
    }
}
