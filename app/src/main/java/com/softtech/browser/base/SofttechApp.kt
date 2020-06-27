package com.softtech.browser.base

import android.app.Application


class SofttechApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    companion object {

        private var instance: SofttechApp? = null

        fun getInstance(): SofttechApp? {
            return instance
        }
    }
}
