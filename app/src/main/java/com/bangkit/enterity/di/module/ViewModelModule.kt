package com.bangkit.enterity.di.module

import androidx.lifecycle.ViewModel
import com.bangkit.enterity.di.ViewModelKey
import com.bangkit.enterity.ui.main.fragment.home.HomeViewModel
import com.bangkit.enterity.ui.start.StartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeVM(homeViewModel: HomeViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    abstract fun bindStartVM(startViewModel: StartViewModel) : ViewModel




//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}