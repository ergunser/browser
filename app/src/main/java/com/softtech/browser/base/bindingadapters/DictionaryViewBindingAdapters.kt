package com.softtech.browser.base.bindingadapters

import androidx.databinding.BindingAdapter
import com.softtech.browser.base.ui.customviews.DictionaryLayout
import com.softtech.browser.base.ui.model.DictionaryModel

@BindingAdapter("dictionaryModel")
fun setDictionaryList(
    dictionaryLayout: DictionaryLayout,
    dictionaryModel: DictionaryModel
) {
    dictionaryLayout.setDictionaryModel(dictionaryModel)

}
