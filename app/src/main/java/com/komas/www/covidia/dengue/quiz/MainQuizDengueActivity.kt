package com.komas.www.covidia.quiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.komas.www.covidia.R

class MainQuizDengueActivity : AppCompatActivity() {

    private var txtHighScore: TextView? = null

    private var mhighscore: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quiz)

        txtHighScore = findViewById(R.id.highscore)
        loadHighScore()


        val startQuiz = findViewById<Button>(R.id.startButton)
        startQuiz.setOnClickListener {
            startActivityForResult(Intent(applicationContext, QuizDengueActivity::class.java), REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super .onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val score = data!!.getIntExtra(QuizActivity.FINAL_SCORE, 0)
                if (score > mhighscore) {
                    updateScore(score)
                }
            }
        }
    }

    private fun updateScore(score: Int) {
        mhighscore = score
        txtHighScore?.text = "My High Score: $mhighscore"

        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt(HIGH_SCORE, mhighscore)
        editor.apply()

    }

    private fun loadHighScore() {
        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        mhighscore = preferences.getInt(HIGH_SCORE, 0)
        txtHighScore?.text = "My High Score: $mhighscore"

    }

    companion object {

        private val REQUEST_CODE = 1
        val PREFS = "shared_prefs"
        val HIGH_SCORE = "high_score"
    }
}