package com.komas.www.covidia.covid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.komas.www.covidia.data.remote.NetworkConfig
import com.komas.www.covidia.data.response.DataCovid
import com.komas.www.covidia.data.response.DataResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DataCovidViewModel: ViewModel() {

    private val dataCovid = MutableLiveData<List<DataCovid>>()
    private val apiService = NetworkConfig.createService()

    fun setDataCovid() {
        apiService.getIndonesiaCovidInfo().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (object : Observer<DataResponse> {
                override fun onComplete() {
                }
                override fun onSubscribe(d: Disposable) {
                }
                override fun onError(e: Throwable) {
                }

                override fun onNext(t: DataResponse) {
                    dataCovid.postValue(t.data)
                }
            })
    }

    fun getDataCovid(): LiveData<List<DataCovid>>{
        return dataCovid
    }

}