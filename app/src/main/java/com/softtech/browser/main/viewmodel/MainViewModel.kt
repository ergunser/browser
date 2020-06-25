package com.softtech.browser.main.viewmodel

import com.softtech.browser.base.viewmodel.BaseViewModel
import com.softtech.browser.main.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    @Inject
    lateinit var api: Api

    private lateinit var subscription: Disposable

    init {
        fetchBrowsers()
    }

    private fun fetchBrowsers() {

        subscription = api.fetchBrowsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //FIXME handle success
            }, {
                //FIXME handle error
            })

    }

}
