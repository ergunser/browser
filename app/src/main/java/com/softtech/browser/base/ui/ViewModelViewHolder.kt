package com.softtech.browser.base.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.softtech.browser.base.viewmodel.RecyclerItemViewModel

open class ViewModelViewHolder(
    parent: ViewGroup,
    @LayoutRes layoutId: Int,
    private val viewModelVariableBindingId: Int,
    protected val binding: ViewDataBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        layoutId,
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {

    protected lateinit var viewModel: RecyclerItemViewModel

    fun bind(viewModel: RecyclerItemViewModel) {
        this.viewModel = viewModel
        this.binding.setVariable(viewModelVariableBindingId, viewModel)
        this.binding.executePendingBindings()
    }

}
