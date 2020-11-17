package com.ryanrvldo.devhub.core.ui

import androidx.annotation.StringRes
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.util.OnHandleResource

interface BaseViewFunction : OnHandleResource {

    fun initLoadingContent()

    fun observeLiveData()

    fun <D> onHandleLiveDataValue(
        value: Resource<D>?,
        onResourceSuccess: (D) -> Unit = {},
    ) {
        value?.let { resource ->
            when (resource) {
                is Resource.Loading -> onHandleResourceLoading()
                is Resource.Success -> onHandleResourceSuccess(resource, onResourceSuccess)
                is Resource.Error -> onHandleResourceError(resource.message.toString())
            }
        }
    }

    override fun onHandleResourceLoading() {
        showLoadingContent(true)
    }

    override fun <D> onHandleResourceSuccess(resource: Resource<D>, onHandleData: (D) -> Unit) {
        val data = (resource as Resource.Success<D>).data
        data?.let(onHandleData)
        showLoadingContent(false)
    }

    override fun onHandleResourceError(message: String) {
        showSnackbar(message)
        showLoadingContent(false)
    }

    fun showLoadingContent(state: Boolean)

    fun showSnackbar(message: String)

    fun showSnackbar(@StringRes resId: Int)

}
