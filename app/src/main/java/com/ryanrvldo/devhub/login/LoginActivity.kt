package com.ryanrvldo.devhub.login

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ryanrvldo.devhub.BaseApplication
import com.ryanrvldo.devhub.R
import com.ryanrvldo.devhub.core.BuildConfig
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.ui.BaseActivity
import com.ryanrvldo.devhub.core.ui.ViewModelFactory
import com.ryanrvldo.devhub.core.util.Constants
import com.ryanrvldo.devhub.databinding.ActivityLoginBinding
import com.ryanrvldo.devhub.main.MainActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(R.layout.activity_login) {

    private val binding: ActivityLoginBinding by viewBinding(R.id.activity_main_layout)

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: LoginViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding.btnLogin.setOnClickListener {
            launchCustomTabs()
        }
    }

    override fun observeLiveData() {
        viewModel.isUserLogin.observe(this) { value ->
            value?.let {
                if (it is Resource.Success && it.data!!) {
                    toMainActivity()
                }
            }
        }

        viewModel.accessToken.observe(this) { value ->
            onHandleLiveDataValue(value) { token ->
                viewModel.writeUserAccessToken(token.accessToken)
                toMainActivity()
            }
        }
    }

    private fun launchCustomTabs() {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .setToolbarColor(ContextCompat.getColor(this, R.color.blue_dark))
            .setCloseButtonIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_arrow_back))
            .build()
        customTabsIntent.launchUrl(this, Uri.parse(Constants.GITHUB_LOGIN_URL))
    }

    private fun toMainActivity() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition()
        } else {
            finish()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = intent?.data
        if (uri != null && uri.toString().startsWith(BuildConfig.CALLBACK_URL)) {
            val code = uri.getQueryParameter("code")
            code?.let {
                viewModel.getAccessToken(it)
            }
        }
    }

    override fun initLoadingContent() {
        super.loadingContent = binding.contentLoading.root
    }

}
