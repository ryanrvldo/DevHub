package com.ryanrvldo.devhub.core.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId),
    BaseViewFunction {

    lateinit var loadingContent: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLoadingContent()
        observeLiveData()
    }

    abstract override fun initLoadingContent()

    override fun observeLiveData() {}

    override fun showLoadingContent(state: Boolean) {
        if (state) {
            loadingContent.visibility = View.VISIBLE
        } else {
            loadingContent.visibility = View.GONE
        }
    }

    override fun showSnackbar(message: String) {
        if (this::loadingContent.isInitialized) {
            Snackbar.make(loadingContent.rootView, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    override fun showSnackbar(resId: Int) {
        if (this::loadingContent.isInitialized) {
            Snackbar.make(loadingContent.rootView, resId, Snackbar.LENGTH_LONG)
                .show()
        }
    }

}
