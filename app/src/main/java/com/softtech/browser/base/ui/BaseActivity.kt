package com.softtech.browser.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.softtech.browser.base.viewmodel.BaseViewModel

abstract class BaseActivity : AppCompatActivity() {

    open lateinit var viewModel: BaseViewModel

    override fun onPostCreate(savedInstanceState: Bundle?) { // FIXME find proper lifecycle event
        super.onPostCreate(savedInstanceState)

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
    }

    open fun hideError() {}

    open fun showError(errorMessage: String?) {}
}
