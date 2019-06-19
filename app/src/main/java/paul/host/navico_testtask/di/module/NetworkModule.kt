package paul.host.navico_testtask.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import paul.host.navico_testtask.data.network.ApiService
import paul.host.navico_testtask.data.network.MapBoxService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    @Named("github")
    fun provideRetrofit(gson: Gson): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cache(null)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.github.com/")
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    @Named("mapbox")
    fun provideRetrofitMap(gson: Gson): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cache(null)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.mapbox.com/geocoding/v5/")
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(
        @Named("github") retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun provideMapBoxService(
        @Named("mapbox") retrofit: Retrofit
    ): MapBoxService = retrofit.create(MapBoxService::class.java)
}