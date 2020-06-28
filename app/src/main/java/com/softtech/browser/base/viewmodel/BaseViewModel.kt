package com.softtech.browser.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softtech.browser.base.network.NetworkModule
import com.softtech.browser.main.viewmodel.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    private val disposeBag = CompositeDisposable()
    val errorMessage = MutableLiveData<String>()

    init {
        inject()
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }

    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }

    protected fun Disposable.autoDispose() {
        disposeBag.add(this)
    }

}
