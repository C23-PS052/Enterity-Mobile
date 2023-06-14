package com.bangkit.enterity.di

import android.app.Application
import com.bangkit.enterity.di.module.ActivityBuildersModule
import com.bangkit.enterity.di.module.AppModule
import com.bangkit.enterity.di.module.FragmentBuildersModule
import com.bangkit.enterity.di.module.NetworkModule
import com.bangkit.enterity.tools.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,AndroidSupportInjectionModule::class, FragmentBuildersModule::class, ActivityBuildersModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: MyApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
