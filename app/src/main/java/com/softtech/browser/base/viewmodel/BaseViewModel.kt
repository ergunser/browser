package com.softtech.browser.base.viewmodel

import androidx.lifecycle.ViewModel
import com.softtech.browser.base.network.NetworkModule
import com.softtech.browser.main.viewmodel.MainViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }

}
