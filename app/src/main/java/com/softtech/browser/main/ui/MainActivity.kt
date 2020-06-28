package com.softtech.browser.main.ui

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.softtech.browser.R
import com.softtech.browser.base.ui.BaseActivity
import com.softtech.browser.databinding.ActivityMainBinding
import com.softtech.browser.main.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java) // FIXME change this

        binding.lifecycleOwner = this
        binding.viewModel = viewModel as MainViewModel
    }

    override fun showError(errorMessage: String?) {
        super.showError(errorMessage)
        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_SHORT).show()
    }
}
