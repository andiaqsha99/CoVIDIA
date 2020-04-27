package com.komas.www.covidia.dengue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.komas.www.covidia.R
import kotlinx.android.synthetic.main.activity_data_dengue.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class DataDengueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_dengue)
        setSupportActionBar(toolbar)
        tv_title_toolbar.text = "Data DBD"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        progress_bar.visibility = View.VISIBLE
        val adapter = ProvinceItemAdapter()
        rv_province.layoutManager = LinearLayoutManager(this)
        rv_province.adapter = adapter

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DataDengueViewModel::class.java]

        viewModel.setDataDengue()
        viewModel.getDataDengue().observe(this, Observer {
            adapter.setData(it)
            progress_bar.visibility = View.INVISIBLE
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
