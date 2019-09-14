package com.sonalsatpute.stringcalculator

sealed class Result<out F, out S>

inline fun <F, S> Result<F, S>.onEachSuccess(f: (S) -> Unit): Result<F, S> {
    when (this) {
        is Success<S> -> f(this.value)
    }

    return this
}

data class Success<out S>(val value: S) : Result<Nothing, S>() {
    override fun toString() = "Success($value)"
}

data class Failure<out F>(val reason: F) : Result<F, Nothing>() {
    override fun toString() = "Failure($reason)"
}

inline fun <F, S> Result<F, S>.orElse(f: (F) -> S): S =
    when (this) {
        is Success -> this.value
        is Failure -> f(this.reason)
    }