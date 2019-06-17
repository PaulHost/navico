package paul.host.navico_testtask.di

import dagger.Component
import paul.host.navico_testtask.App
import paul.host.navico_testtask.di.module.AppModule
import paul.host.navico_testtask.di.module.NetworkModule
import paul.host.navico_testtask.di.module.RepositoryModule
import javax.inject.Singleton

@Suppress("DEPRECATION")
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    object Initializer {
        fun init(app: App): AppComponent {
            return DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .build()
        }
    }
}