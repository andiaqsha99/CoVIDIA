package com.komas.www.covidia.quiz

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.komas.www.covidia.quiz.QuizContainer.QuizTable.Companion.ANS_COLUMN
import com.komas.www.covidia.quiz.QuizContainer.QuizTable.Companion.OPTION1_COLUMN
import com.komas.www.covidia.quiz.QuizContainer.QuizTable.Companion.OPTION2_COLUMN
import com.komas.www.covidia.quiz.QuizContainer.QuizTable.Companion.OPTION3_COLUMN
import com.komas.www.covidia.quiz.QuizContainer.QuizTable.Companion.QUESTION_COLUMN
import com.komas.www.covidia.quiz.QuizContainer.QuizTable.Companion.QUESTION_TABLE_NAME
import java.util.ArrayList

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private var db: SQLiteDatabase? = null

    val questionSet: List<Question>
        get() {

            val questionSetsList = ArrayList<Question>()

            db = readableDatabase

            val c = db!!.rawQuery("SELECT * FROM $QUESTION_TABLE_NAME", null)

            if (c.moveToFirst()) {
                do {
                    val question = Question()
                    question.setmQuestion(c.getString(c.getColumnIndex(QUESTION_COLUMN)))
                    question.setmOption1(c.getString(c.getColumnIndex(OPTION1_COLUMN)))
                    question.setmOption2(c.getString(c.getColumnIndex(OPTION2_COLUMN)))
                    question.setmOption3(c.getString(c.getColumnIndex(OPTION3_COLUMN)))
                    question.setmRightAns(c.getInt(c.getColumnIndex(ANS_COLUMN)))
                    questionSetsList.add(question)
                } while (c.moveToNext())

            }
            c.close()
            return questionSetsList
        }

    override fun onCreate(db: SQLiteDatabase) {
        this.db = db

        val QB_TABLE = "CREATE TABLE " +
                QUESTION_TABLE_NAME + " ( " +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QUESTION_COLUMN + " TEXT, " +
                OPTION1_COLUMN + " TEXT, " +
                OPTION2_COLUMN + " TEXT, " +
                OPTION3_COLUMN + " TEXT, " +
                ANS_COLUMN + " INTEGER " +
                " )"

        db.execSQL(QB_TABLE)

        GenerateQuestionFunction()
    }

    private fun GenerateQuestionFunction() {
        val q1 = Question("Manakah dari hal berikut yang tidak dapat membantu mengurangi kemungkinan terpapar virus corona?",
            "Menggunakan masker kain", "Mencuci tangan", "Bepergian ke luar rumah tanpa urusan penting", 3)
        addQuestion(q1)
        val q2 = Question("Manakah yang tidak benar dari informasi berikut?",
            "Coronavirus mampu bertahan pada permukaan beda selama waktu tertentu",
            "Coronavirus tidak dapat menyerang orang muda",
            "Coronavirus dapat bertahan di udara beberapa saat", 2)
        addQuestion(q2)
        val q3 = Question("Berapa jarak yang harus kita jaga dari orang lain?",
            "50 centimeter", "1-2 meter", "Tidak perlu jaga jarak", 2)
        addQuestion(q3)
        val q4 = Question("Apakah yang harusnya kita tidak lakukan jika kita merasa sedang tidak sehat?",
            "Bepergian", "Memakai masker", "Beristirahat di rumah", 1)
        addQuestion(q4)
        val q5 = Question("Apa hal yang sebaiknya tidak kamu lakukan setelah bepergian dari luar rumah?",
            "Menyentuh bagian wajah", "Mencuci tangan",
            "Mandi dan menaruh pakaian di tempat cucian", 1)
        addQuestion(q5)
        val q6= Question("Manakah dari hal di bawah ini yang tidak tepat?",
            "Semua orang dapat terpapar virus corona",
            "Orang muda dan sehat tidak akan bisa sakit karena virus corona",
            "Orang yang sembuh dari penyakit covid tidak dapat terkena kembali untuk kedua kalinya", 2)
        addQuestion(q6)
        val q7 = Question("Pilih dari informasi berikut yang merupakan hoax!",
            "Memakan bawang bawangan (bawang putih, bawang bombay) dapat menghindarkan diri dari virus corona",
            "Virus corona dapat bertahan di benda yang tersentuh oleh orang yang mengidap covid-19",
            "Virus corona bisa bertahan di udara selama beberapa saat", 1)
        addQuestion(q7)
        val q8 = Question("Manakah dari pernyataan berikut yang benar",
            "Orang yang pernah terjangkit demam berdarah tidak akan pernah terjangkit kembali",
            "Orang yang pernah terjangkit bisa terjangkit kembali oleh virus dengue berbeda",
            "Orang yang pernah terjangkit bisa terjangkit kembali oleh virus dengue yang sama", 2)
        addQuestion(q8)
        val q9 = Question("Manakah cara penyebaran virus dengue yang benar?",
            "Kontak fisik dengan orang yang terjangkit",
            "Terkena bersin atau batuk orang yang sakit",
            "Terkena gigitan nyamuk jenis aedes aegypti", 3)
        addQuestion(q9)
        val q10 = Question("Pada waktu apakah nyamuk aedes aegypti lebih sering mengigit manusia?",
            "Siang hari", "Malam hari", "Sore Hari", 1)
        addQuestion(q10)
        val q11 = Question("Yang tidak termasuk dalam gejala yang ditimbulkan oleh demam berdarah adalah:",
            "Nafsu makan menurun", "Batuk-batuk", "Mual dan muntah-muntah", 2)
        addQuestion(q11)
        val q12 = Question("Manakah hal yang tidak membantu untuk mengurangi kemungkinan terjangkit demam berdarah?",
            "Membersihkan lingkungan sekitar", "Mendapatkan vaksin demam berdarah",
            "Mengenakan pakaian terbuka", 3)
        addQuestion(q12)
        val q13= Question("Apakah yang harus kita hindari jika kita mengalami gejala demam berdarah?",
            "Istirahat yang cukup",
            "Aktivitas yang berat atau melelahkan",
            "Mengkonsumsi banyak air mineral", 2)
        addQuestion(q13)
        val q14 = Question("Informasi yang tidak benar mengenai demam berdarah dari pilihan berikut ini adalah:",
            "Parasetamol dapat digunakan sebagai obat bantu meredakan gejala demam berdarah",
            "Jus daun pepaya dapat menghindarkan kita dari demam berdarah",
            "Demam berdarah dapat menyerang manusia di segala umur", 2)
        addQuestion(q14)
    }

    private fun addQuestion(qb: Question) {
        val contentValues = ContentValues()
        contentValues.put(QUESTION_COLUMN, qb.getmQuestion())
        contentValues.put(OPTION1_COLUMN, qb.getmOption1())
        contentValues.put(OPTION2_COLUMN, qb.getmOption2())
        contentValues.put(OPTION3_COLUMN, qb.getmOption3())
        contentValues.put(ANS_COLUMN, qb.getmRightAns())
        db!!.insert(QUESTION_TABLE_NAME, null, contentValues)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    companion object {
        private val DATABASE_NAME = "QuizCovid.db"
        private val DATABASE_VERSION = 1
    }

}