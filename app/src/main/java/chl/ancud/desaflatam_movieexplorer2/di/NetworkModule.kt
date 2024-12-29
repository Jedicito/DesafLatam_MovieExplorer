package chl.ancud.desaflatam_movieexplorer2.di

import chl.ancud.desaflatam_movieexplorer2.BuildConfig
import chl.ancud.desaflatam_movieexplorer2.datos.remoto.MovieApi
import chl.ancud.desaflatam_movieexplorer2.datos.remoto.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val TOKEN = BuildConfig.TMDB_API_KEY

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
        client.addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader(
                "accept",
                "application/json"
            )
            requestBuilder.header(
                "Authorization",
                "Bearer $TOKEN"
            )
            chain.proceed(requestBuilder.build())
        }
        val okHttpClient = client.build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            //.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

}