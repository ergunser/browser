package com.softtech.browser.base.ui

import com.softtech.browser.base.viewmodel.RecyclerItemViewModel

interface ViewModelLayoutHolder {

    val viewModel: RecyclerItemViewModel

    val layoutResId: Int
}

