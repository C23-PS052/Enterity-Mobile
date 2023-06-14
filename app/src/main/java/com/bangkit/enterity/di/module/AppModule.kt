package com.bangkit.enterity.di.module

import android.app.Application
import android.content.Context
import com.bangkit.enterity.tools.SessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {
//    @JvmStatic
    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideSessionManager(context: Context): SessionManager {
        return SessionManager(context)
    }
}
