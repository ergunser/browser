package com.softtech.browser.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.softtech.browser.R
import com.softtech.browser.base.ui.model.DictionaryModel
import com.softtech.browser.base.ui.model.KeyValueModel
import com.softtech.browser.base.viewmodel.BaseViewModel
import com.softtech.browser.main.model.BrowserResponse
import com.softtech.browser.main.model.Item
import com.softtech.browser.main.network.Api
import com.softtech.browser.main.ui.BrowserItemViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    val browserList = MutableLiveData<MutableList<BrowserItemViewHolder>>()
    val progressBarVisible = MutableLiveData<Boolean>().apply { value = true }

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

                handleBrowserResponse(it)

            }, {
                //FIXME handle error
                progressBarVisible.value = false

            }).autoDispose()

    }

    private fun handleBrowserResponse(browserResponse: BrowserResponse?) {

        progressBarVisible.value = false

        val list = mutableListOf<BrowserItemViewHolder>()

        browserResponse?.items?.map {
            BrowserItemViewModel(
                createDictionaryModelFromBrowserResponse(
                    it
                )
            )
        }
            ?.mapTo(list) { BrowserItemViewHolder(it) }


        browserList.value = list
    }

    private fun createDictionaryModelFromBrowserResponse(responseBrowserItem: Item): DictionaryModel {

        val browserItem = KeyValueModel(
            R.string.browser_label,
            responseBrowserItem.browser?.appCodeName.orEmpty()
        )

        val platformItem = KeyValueModel(
            R.string.platform_label,
            responseBrowserItem.computedBrowser?.platform.orEmpty()
        )

        val locationItem =
            KeyValueModel(R.string.geolocation_label, responseBrowserItem.geo?.country.orEmpty())

        val ratingItem =
            KeyValueModel(R.string.ratings_label, responseBrowserItem.rating.toString())

        val labelItem =
            KeyValueModel(R.string.labels_label, responseBrowserItem.labels?.getOrNull(0).orEmpty())

        val keyValueList = ArrayList<KeyValueModel>().apply {
            add(browserItem)
            add(platformItem)
            add(locationItem)
            add(ratingItem)
            add(labelItem)
        }

        return DictionaryModel(keyValueList)


    }

}
