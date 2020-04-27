package com.komas.www.covidia.dengue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.komas.www.covidia.data.remote.NetworkConfig
import com.komas.www.covidia.data.response.dbd.DbdResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DataDengueViewModel: ViewModel() {
    private val dataDengue = MutableLiveData<DbdResponse>()
    private val apiService = NetworkConfig.createServiceDBD()

    fun setDataDengue(){
        apiService.getIndonesiaDbdInfo().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<DbdResponse>{
                override fun onComplete() {
                }
                override fun onSubscribe(d: Disposable) {
                }
                override fun onError(e: Throwable) {
                }

                override fun onNext(t: DbdResponse) {
                    dataDengue.postValue(t)
                }
            })
    }

    fun getDataDengue() : LiveData<DbdResponse>{
        return dataDengue
    }
}