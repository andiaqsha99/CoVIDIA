package com.komas.www.covidia.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.komas.www.covidia.R
import com.komas.www.covidia.data.response.DataCovid
import kotlinx.android.synthetic.main.activity_data_covid.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.text.SimpleDateFormat
import java.util.*

class DataCovidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_covid)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_title_toolbar.text = "Data COVID"

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DataCovidViewModel::class.java]

        viewModel.setDataCovid()
        viewModel.getDataCovid().observe(this, Observer {
            val dataCovid = it.last()
            populateView(dataCovid)
        })
    }

    private fun populateView(data: DataCovid) {
        tv_confirmed.text = data.caseCumulative
        tv_confirmed_today.text = data.caseToday
        tv_death.text = data.deathCumulative
        tv_death_today.text = data.deathToday
        tv_recovered.text = data.recoveredCumulative
        tv_recovered_today.text = data.recoveredToday
        tv_treated.text = data.treatedCumulative
        tv_treated_today.text = data.treatedToday

        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val dateToday = formatter.format(Date(data.date))
        tv_dateToday.text = dateToday
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
