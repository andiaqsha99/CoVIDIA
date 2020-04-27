package com.komas.www.covidia.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    private fun getNetwork(): Retrofit =
        Retrofit.Builder()
        .baseUrl("https://indonesia-covid-19.mathdro.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun createService(): Api {
        return getNetwork().create(Api::class.java)
    }

    private fun getNetworkDBD(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://fierce-anchorage-83457.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun createServiceDBD(): Api {
        return getNetworkDBD().create(Api::class.java)
    }
}