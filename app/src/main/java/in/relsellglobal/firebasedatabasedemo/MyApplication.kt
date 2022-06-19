package `in`.relsellglobal.firebasedatabasedemo

import `in`.relsellglobal.firebasedatabasedemo.di.DaggerApplicationComponent
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}