package com.sonalsatpute.stringcalculator.fp

sealed class Result<out F, out T> {

    abstract fun <S> mapSuccess(f: (T) -> S): Result<F, S>
}

data class Success<out F, out T>(val value: T): Result<F, T>() {

    override fun <S> mapSuccess(f: (T) -> S): Result<F, S> = Success(f(this.value))

    override fun toString() = "Success($value)"
}

data class Failure<out F, out T>(val reason: F) : Result<F, T>() {

    override fun <S> mapSuccess(f: (T) -> S): Result<F, S> = Failure(this.reason)

    override fun toString() = "Failure($reason)"
}