package com.softtech.browser.base.ui.model

import androidx.annotation.StringRes
import com.softtech.browser.base.util.ResourceUtil

data class KeyValueModel(var key: String, var value: String) {

    constructor(@StringRes keyResource: Int, @StringRes valueResource: Int) : this(
        ResourceUtil.getString(keyResource),
        ResourceUtil.getString(valueResource)
    )

    constructor(@StringRes keyResource: Int, value: String) : this(
        ResourceUtil.getString(keyResource),
        value
    )

    constructor(key: String, @StringRes valueResource: Int) : this(
        key,
        ResourceUtil.getString(valueResource)
    )
}
