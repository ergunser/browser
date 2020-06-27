package com.softtech.browser.base.bindingadapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.softtech.browser.base.ui.ViewModelLayoutHolder
import com.softtech.browser.base.ui.ViewModelRecyclerViewAdapter

@BindingAdapter("viewModelList")
fun viewModelList(
    recyclerView: RecyclerView,
    list: List<ViewModelLayoutHolder>?
) {

    if (recyclerView.adapter == null) {
        recyclerView.adapter = ViewModelRecyclerViewAdapter()
    }

    (recyclerView.adapter as? ViewModelRecyclerViewAdapter)?.updateData(list)
}
