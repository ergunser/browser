package com.softtech.browser.base.extensions


fun Boolean?.orFalse() = this ?: false

fun Boolean?.orTrue() = this ?: true

fun checkAll(vararg conditions: Boolean) = conditions.all { it }

fun checkAny(vararg conditions: Boolean) = conditions.any { it }
