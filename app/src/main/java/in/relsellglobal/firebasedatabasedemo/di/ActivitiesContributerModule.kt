package `in`.relsellglobal.firebasedatabasedemo.di

import `in`.relsellglobal.firebasedatabasedemo.FrontListFragment
import `in`.relsellglobal.firebasedatabasedemo.MainActivityForWeatherData
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesContributerModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity () : MainActivityForWeatherData
}