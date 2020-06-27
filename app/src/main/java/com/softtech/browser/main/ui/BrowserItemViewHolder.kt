package com.softtech.browser.main.ui

import com.softtech.browser.R
import com.softtech.browser.base.ui.ViewModelLayoutHolder
import com.softtech.browser.main.viewmodel.BrowserItemViewModel

class BrowserItemViewHolder(override val viewModel: BrowserItemViewModel) : ViewModelLayoutHolder {

    override val layoutResId: Int
        get() = R.layout.list_item_browser

}
