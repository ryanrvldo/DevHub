package com.ryanrvldo.devhub.di

import com.ryanrvldo.devhub.core.di.AppScope
import com.ryanrvldo.devhub.core.di.CoreComponent
import com.ryanrvldo.devhub.login.LoginActivity
import com.ryanrvldo.devhub.main.MainActivity
import com.ryanrvldo.devhub.main.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(loginActivity: LoginActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(homeFragment: HomeFragment)

}
