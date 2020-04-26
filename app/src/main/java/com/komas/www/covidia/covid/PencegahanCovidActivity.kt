package com.komas.www.covidia.covid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import com.komas.www.covidia.R
import kotlinx.android.synthetic.main.activity_pencegahan_covid.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class PencegahanCovidActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pencegahan_covid)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_title_toolbar.text = "Pencegahan"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
