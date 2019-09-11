package com.sonalsatpute.stringcalculator

sealed class Result<out F, out S>

data class Success<out S>(val value: S) : Result<Nothing, S>() {
    override fun toString() = "Success($value)"
}

data class Failure<out F>(val reason: F) : Result<F, Nothing>() {
    override fun toString() = "Failure($reason)"
}