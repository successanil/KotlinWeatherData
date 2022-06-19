package `in`.relsellglobal.firebasedatabasedemo.di

import `in`.relsellglobal.firebasedatabasedemo.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    FragmentsContributerModule::class,
    ActivitiesContributerModule::class]
)
interface ApplicationComponent {
    fun inject(app : MyApplication)
}