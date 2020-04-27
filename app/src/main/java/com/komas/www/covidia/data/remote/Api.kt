package com.komas.www.covidia.data.remote

import com.komas.www.covidia.data.response.covid.DataResponse
import com.komas.www.covidia.data.response.dbd.DbdResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("api/harian")
    fun getIndonesiaCovidInfo(): Observable<DataResponse>

    @GET("dbd/")
    fun getIndonesiaDbdInfo(): Observable<DbdResponse>
}