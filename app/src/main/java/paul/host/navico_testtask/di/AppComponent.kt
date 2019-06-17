package paul.host.navico_testtask.di

import dagger.Component
import paul.host.navico_testtask.App
import paul.host.navico_testtask.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    object Initializer {
        fun init(app: App): AppComponent {
            return DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()
        }
    }
}