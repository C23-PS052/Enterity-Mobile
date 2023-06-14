package com.bangkit.enterity.di.module


import com.bangkit.enterity.ui.MainActivity
import com.bangkit.enterity.ui.start.StartActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun bindActMain(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindActStart(): StartActivity


}
