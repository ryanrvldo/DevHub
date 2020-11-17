package com.ryanrvldo.devhub

import android.app.Application
import com.ryanrvldo.devhub.core.di.CoreComponent
import com.ryanrvldo.devhub.core.di.DaggerCoreComponent
import com.ryanrvldo.devhub.di.AppComponent
import com.ryanrvldo.devhub.di.DaggerAppComponent

class BaseApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

}
