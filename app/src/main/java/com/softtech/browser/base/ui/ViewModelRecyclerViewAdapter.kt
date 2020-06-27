package com.softtech.browser.base.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewModelRecyclerViewAdapter(
    var viewModelLayoutHolderList: ArrayList<ViewModelLayoutHolder> = arrayListOf()
) : RecyclerView.Adapter<ViewModelViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewModelViewHolder, position: Int) {
        viewHolder.bind(viewModelLayoutHolderList[position].viewModel)
    }

    override fun getItemCount() = viewModelLayoutHolderList.size

    override fun getItemViewType(position: Int): Int = viewModelLayoutHolderList[position].layoutResId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SofttechBrowserViewHolder(parent, viewType)

    fun updateData(list: List<ViewModelLayoutHolder>?) {
        viewModelLayoutHolderList.clear()
        viewModelLayoutHolderList.addAll(list.orEmpty())
        notifyDataSetChanged()
    }

}
