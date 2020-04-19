package com.komas.www.covidia.dengue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komas.www.covidia.R
import kotlinx.android.synthetic.main.activity_dengue.*

class DengueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dengue)

        iv_urgent.setOnClickListener{
            startActivity(Intent(this, CallDengueActivity::class.java))
        }
        iv_data.setOnClickListener{

        }
        iv_pencegahan.setOnClickListener{
            startActivity(Intent(this, PencegahanDengueActivity::class.java))
        }
        iv_pengobatan.setOnClickListener{
            startActivity(Intent(this, PengobatanDengueActivity::class.java))
        }
        iv_penyebab.setOnClickListener{
            startActivity(Intent(this, PenyebabDengueActivity::class.java))
        }
        iv_quiz.setOnClickListener{

        }
    }
}
