package com.softtech.browser.main.viewmodel

import com.softtech.browser.base.viewmodel.BaseViewModel
import com.softtech.browser.main.network.Api
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    @Inject
    lateinit var api: Api

}
