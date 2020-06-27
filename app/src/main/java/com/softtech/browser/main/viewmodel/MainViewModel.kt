package com.softtech.browser.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.softtech.browser.base.viewmodel.BaseViewModel
import com.softtech.browser.main.network.Api
import com.softtech.browser.main.ui.BrowserItemViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    val browserList = MutableLiveData<MutableList<BrowserItemViewHolder>>()

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

                val list = mutableListOf<BrowserItemViewHolder>()

                it.items?.map { BrowserItemViewModel(it) }
                    ?.mapTo(list) { BrowserItemViewHolder(it) }


                browserList.value = list
            }, {

            }).autoDispose()

    }

}
