package com.sonalsatpute.stringcalculator

import org.junit.jupiter.api.Assertions

fun <F, S> Result<F, S>.expectSuccess(describe: (F) -> String = { it.toString() }): S =
    when (this) {
        is Success -> value
        is Failure -> Assertions.fail("expected success, but was failure: ${describe(reason)}")
    }