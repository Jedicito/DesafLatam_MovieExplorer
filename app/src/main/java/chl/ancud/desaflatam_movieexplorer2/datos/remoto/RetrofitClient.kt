package chl.ancud.desaflatam_movieexplorer2.datos.remoto

import chl.ancud.desaflatam_movieexplorer2.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val TOKEN = BuildConfig.TMDB_API_KEY

    val movieApi: MovieApi by lazy {
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

        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

}