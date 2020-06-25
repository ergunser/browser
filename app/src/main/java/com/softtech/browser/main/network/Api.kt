package com.softtech.browser.main.network

import com.softtech.browser.main.model.BrowserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("e5714414-3e4d-440a-993a-c76d3fd6d392")
    fun getBrowsers(): Observable<BrowserResponse>

}
