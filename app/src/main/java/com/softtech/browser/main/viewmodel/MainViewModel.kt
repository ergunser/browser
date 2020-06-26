package com.softtech.browser.main.viewmodel

import com.softtech.browser.base.viewmodel.BaseViewModel
import com.softtech.browser.main.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    @Inject
    lateinit var api: Api

    init {
        fetchBrowsers()
    }

    private fun fetchBrowsers() {

        api.fetchBrowsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //FIXME handle success
            }, {
                //FIXME handle error
            }).autoDispose()

    }

}
