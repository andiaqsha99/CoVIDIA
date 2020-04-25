package com.komas.www.covidia.data.remote

import com.komas.www.covidia.data.response.DataResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("api/harian")
    fun getIndonesiaCovidInfo(): Observable<DataResponse>
}