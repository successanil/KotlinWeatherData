package `in`.relsellglobal.firebasedatabasedemo.di

import `in`.relsellglobal.firebasedatabasedemo.DetailFragment
import `in`.relsellglobal.firebasedatabasedemo.FrontListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsContributerModule {

    @ContributesAndroidInjector
    abstract fun contributeProductListFragment () : FrontListFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment () : DetailFragment
}