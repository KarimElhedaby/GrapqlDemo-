package com.hamza.soluations.mygraphqldemo

import android.app.Application
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class App : Application() {

    private val BASE_URL = "https://api.github.com/graphql"

    private val GITHUB_AUTH_TOKEN = "e7537b6452acfacc39b9e2169222c03eeeddd5e5"

    private lateinit var apolloClient: ApolloClient

    override fun onCreate() {
        super.onCreate()


        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor {
                    val original = it.request()
                    val builder = original.newBuilder().method(original.method(), original.body())
                    builder.header("Authorization", "Bearer $GITHUB_AUTH_TOKEN")
                    it.proceed(builder.build())
                }
                .build()


        apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build()
    }

    fun apolloClient(): ApolloClient {
        return this.apolloClient;
    }
}
