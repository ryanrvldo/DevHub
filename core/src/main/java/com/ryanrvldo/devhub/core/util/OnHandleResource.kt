package com.ryanrvldo.devhub.core.util

import com.ryanrvldo.devhub.core.data.Resource

interface OnHandleResource {

    fun onHandleResourceLoading()

    fun <D> onHandleResourceSuccess(resource: Resource<D>, onHandleData: (D) -> Unit)

    fun onHandleResourceError(message: String)

}
