package com.komas.www.covidia.dengue

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komas.www.covidia.R
import kotlinx.android.synthetic.main.activity_call_dengue.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CallDengueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_dengue)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_title_toolbar.text = "Call Urgent"

        btn_call_dengue.setOnClickListener {
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"))
            startActivity(dialPhoneIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
