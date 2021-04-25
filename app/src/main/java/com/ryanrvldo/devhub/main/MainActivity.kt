package com.ryanrvldo.devhub.main

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.customview.widget.Openable
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.ryanrvldo.devhub.BaseApplication
import com.ryanrvldo.devhub.R
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import com.ryanrvldo.devhub.core.ui.BaseActivity
import com.ryanrvldo.devhub.core.ui.ViewModelFactory
import com.ryanrvldo.devhub.core.util.Constants.USERNAME_EXTRA
import com.ryanrvldo.devhub.core.util.GreetingsUtil
import com.ryanrvldo.devhub.databinding.ActivityMainBinding
import javax.inject.Inject
import com.ryanrvldo.devhub.core.R as CoreR

class MainActivity : BaseActivity(), Openable {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLoadingContent()
        setSupportActionBar(binding.appBarMain.toolbar)
        setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.navigationView, navController)

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment
        ).setOpenableLayout(this)
            .build()
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun observeLiveData() {
        viewModel.userDetails.observe(this) { value ->
            value?.let { resource ->
                if (resource is Resource.Success) {
                    resource.data?.let { setupNavigationHeader(it) }
                } else if (resource is Resource.Error) {
                    showSnackbar(resource.message!!)
                }
            }
        }
    }

    private fun setupNavigationHeader(userDetails: UserDetails) {
        val header = binding.navigationView.getHeaderView(0)
        val imgAvatar = header.findViewById<ShapeableImageView>(R.id.img_user_avatar)
        val tvGreetings = header.findViewById<TextView>(R.id.tv_greetings)
        val tvUserFullName = header.findViewById<TextView>(R.id.tv_user_full_name)
        val tvUsername = header.findViewById<TextView>(R.id.tv_username)
        val tvEmail = header.findViewById<TextView>(R.id.tv_user_email)

        tvGreetings.text = GreetingsUtil.getGreetings(this)
        with(userDetails) {
            Glide.with(this@MainActivity)
                .load(avatarUrl)
                .error(CoreR.drawable.ic_image_error_light)
                .into(imgAvatar)
            tvUserFullName.text = name
            tvUsername.text = username
            tvEmail.text = email
        }

        val bundle = bundleOf(USERNAME_EXTRA to userDetails.username)
        navController.setGraph(R.navigation.main_nav_graph, bundle)
    }

    override fun initLoadingContent() {
        super.loadingContent = binding.contentLoading.root
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController,
            appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.mainDrawerLayout.closeDrawers()
            return
        }
        super.onBackPressed()
    }

    override fun isOpen(): Boolean {
        return binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)
    }

    override fun open() {
        binding.mainDrawerLayout.openDrawer(GravityCompat.START)
    }

    override fun close() {
        binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
    }

}
