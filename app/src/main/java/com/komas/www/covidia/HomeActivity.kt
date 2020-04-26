package com.komas.www.covidia

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.komas.www.covidia.covid.CovidActivity
import com.komas.www.covidia.dengue.DengueActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_covid.setOnClickListener(this)
        btn_dengue.setOnClickListener(this)
        iv_covid.setOnClickListener (this)
        iv_dengue.setOnClickListener(this)
        btn_group.setOnClickListener(this)
        iv_out.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intentCovid = Intent(this, CovidActivity::class.java)
        val intentDengue = Intent(this, DengueActivity::class.java)
        when(view?.id) {
            R.id.btn_covid -> {
                startActivity(intentCovid)
            }
            R.id.btn_dengue -> {
                startActivity(intentDengue)
            }
            R.id.iv_covid -> {
                startActivity(intentCovid)
            }
            R.id.iv_dengue -> {
                startActivity(intentDengue)
            }
            R.id.btn_group -> {
                startActivity(Intent(this, GroupActivity::class.java))
            }
            R.id.iv_out -> {
                onBackPressed()
            }
        }
    }
}