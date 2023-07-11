package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.surveyapp.databinding.ActivityResultBinding
import com.example.surveyapp.model.PersonSurveyInfo

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private var backPressedTime: Long = 0
    private val backPressedInterval: Long = 2000 // 2 saniye

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personSurvey = intent.getParcelableExtra("personSurvey") as PersonSurveyInfo?

        with(binding) {
            tvInfo1.text = personSurvey?.person?.name.toString()
            tvInfo2.text = personSurvey?.person?.age.toString()
            tvInfo3.text = personSurvey?.person?.email.toString()
            tvInfo4.text = personSurvey?.person?.country.toString()
            tvInfo5.text = personSurvey?.person?.city.toString()
            tvInfo6.text = personSurvey?.answer1.toString()
            tvInfo7.text = personSurvey?.answer2.toString()
            tvInfo8.text = personSurvey?.answer3.toString()
            tvInfo9.text = personSurvey?.answer4.toString()

            btnHome.setOnClickListener {
                val intent = Intent(this@ResultActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - backPressedTime < backPressedInterval) {
                    // İkinci kez geri tuşuna basıldı, 1. sayfaya git ve diğer sayfaları temizle
                    val intent = Intent(this@ResultActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@ResultActivity, "Ana Sayfaya dönmek için tekrar basınız.", Toast.LENGTH_SHORT).show()
                    backPressedTime = System.currentTimeMillis()
                }
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)
    }
}