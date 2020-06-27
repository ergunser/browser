package com.softtech.browser.base.util

import android.content.Context
import androidx.annotation.StringRes
import com.softtech.browser.base.SofttechApp

object ResourceUtil {

    private val context: Context
        get() = SofttechApp.getInstance()?.applicationContext!!

    fun getString(@StringRes resId: Int) = context.getString(resId)

    fun getString(@StringRes resId: Int, vararg formatArgs: Any) = context.getString(resId, *formatArgs)


}
