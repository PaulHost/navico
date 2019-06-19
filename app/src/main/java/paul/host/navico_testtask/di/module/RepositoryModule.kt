package paul.host.navico_testtask.di.module

import dagger.Module
import dagger.Provides
import paul.host.navico_testtask.data.network.ApiService
import paul.host.navico_testtask.data.network.MapBoxService
import paul.host.navico_testtask.data.repasitory.Repository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(api: ApiService, map: MapBoxService) = Repository(api, map)
}