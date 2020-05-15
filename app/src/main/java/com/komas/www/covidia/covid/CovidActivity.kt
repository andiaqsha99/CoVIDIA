package com.komas.www.covidia.covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.komas.www.covidia.R
import com.komas.www.covidia.quiz.MainQuizActivity
import kotlinx.android.synthetic.main.activity_covid.*

class CovidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        iv_urgent.setOnClickListener{
            startActivity(Intent(this, CallCovidActivity::class.java))
        }
        iv_data.setOnClickListener{
            startActivity(Intent(this, DataCovidActivity::class.java))
        }
        iv_pencegahan.setOnClickListener{
            startActivity(Intent(this, PencegahanCovidActivity::class.java))
        }
        iv_pengobatan.setOnClickListener{
            startActivity(Intent(this, PengobatanCovidActivity::class.java))
        }
        iv_penyebab.setOnClickListener{
            startActivity(Intent(this, PenyebabCovidActivity::class.java))
        }
        iv_quiz.setOnClickListener{
            startActivity(Intent(this, MainQuizActivity::class.java))
        }
    }
}
