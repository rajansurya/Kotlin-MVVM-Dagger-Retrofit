package com.app.module

import android.app.Application
import com.component.AndroidApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,AppModule::class, NetModule::class, AppActivityModule::class))
interface AppComponent {
    abstract fun inject(app: AndroidApplication)

    @Component.Builder
    interface buildapp {
        @BindsInstance
        fun application(application: Application): buildapp

        @BindsInstance
        fun netModulesetter(@BaseURL baseURL: String): buildapp

        fun build(): AppComponent

    }
}