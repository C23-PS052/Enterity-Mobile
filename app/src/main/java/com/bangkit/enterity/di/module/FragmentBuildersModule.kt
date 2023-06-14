package com.bangkit.enterity.di.module


import com.bangkit.enterity.ui.main.fragment.analytics.AnalyticsFragment
import com.bangkit.enterity.ui.main.fragment.home.HomeFragment
import com.bangkit.enterity.ui.main.fragment.product.ProductFragment
import com.bangkit.enterity.ui.start.login.LoginFragment
import com.bangkit.enterity.ui.start.register.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {


    @ContributesAndroidInjector
    abstract fun bindAnalytics(): AnalyticsFragment

    @ContributesAndroidInjector
    abstract fun bindHome(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindProduct(): ProductFragment

    @ContributesAndroidInjector
    abstract fun bindLogin(): LoginFragment

    @ContributesAndroidInjector
    abstract fun bindRegister(): RegisterFragment
}