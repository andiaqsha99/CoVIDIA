package com.komas.www.covidia.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komas.www.covidia.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class PenyebabCovidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penyebab_covid)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_title_toolbar.text = "Penyebab"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
