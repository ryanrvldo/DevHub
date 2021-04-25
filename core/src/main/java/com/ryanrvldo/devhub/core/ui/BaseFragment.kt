package com.ryanrvldo.devhub.core.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment(),
    BaseViewFunction {

    lateinit var loadingContent: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLoadingContent()
        observeLiveData()
    }

    abstract override fun initLoadingContent()

    override fun showLoadingContent(state: Boolean) {
        if (state) {
            loadingContent.visibility = View.VISIBLE
        } else {
            loadingContent.visibility = View.GONE
        }
    }

    override fun showSnackbar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG)
            .show()
    }

    override fun showSnackbar(@StringRes resId: Int) {
        Snackbar.make(requireView(), resId, Snackbar.LENGTH_LONG)
            .show()
    }

}
