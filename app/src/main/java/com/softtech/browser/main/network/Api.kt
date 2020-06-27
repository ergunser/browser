package com.softtech.browser.main.network

import com.softtech.browser.main.model.BrowserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("06df161a-9b16-4da1-880e-423000629acf")
    fun fetchBrowsers(): Observable<BrowserResponse>

}
