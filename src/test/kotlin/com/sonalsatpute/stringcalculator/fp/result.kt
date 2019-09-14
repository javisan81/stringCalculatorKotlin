package com.sonalsatpute.stringcalculator.fp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.fail

fun <F, S> Result<F, S>.expectSuccess(describe: (F) -> String = { it.toString() }): S =
    when (this) {
        is Success -> value
        is Failure -> Assertions.fail("expected success, but was failure: ${describe(reason)}")
    }

fun <F, S> Result<F, S>.expectFailure(describe: (S) -> String = { t -> t.toString() }): F =
    when (this) {
        is Success -> fail("expected failure, but was success: ${describe(value)}")
        is Failure -> reason
    }