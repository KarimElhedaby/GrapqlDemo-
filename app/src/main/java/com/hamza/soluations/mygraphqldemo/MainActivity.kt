package com.hamza.soluations.mygraphqldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application: App by lazy {
            getApplication() as App
        }
        application.apolloClient().query(
            LoadGithubRepositories
                .builder().login("KarimElhedaby").build()
        ).enqueue(object : ApolloCall.Callback<LoadGithubRepositories.Data>(){
            override fun onFailure(e: ApolloException) {
            }

            override fun onResponse(response: Response<LoadGithubRepositories.Data>) {
                Log.d("graphTest",response.toString())
            }


        }

)


    }
}


