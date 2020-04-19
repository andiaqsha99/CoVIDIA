package com.komas.www.covidia.dengue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komas.www.covidia.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class CallDengueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_dengue)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_title_toolbar.text = "Call Urgent"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
