package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityCustomBinding
import com.example.surveyapp.model.Person
import com.example.surveyapp.model.PersonSurveyInfo

class CustomActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra("person") as Person?
        var selectedValue: String = ""

        with(binding) {
            tvName.text = person?.name.toString()
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val radioButton: RadioButton = findViewById(checkedId)
                selectedValue = radioButton.text.toString()
            }
            btnSave.setOnClickListener {
                val answer1 = etA1.text.toString()
                val answer2 = etA2.text.toString()
                val answer3 = etA3.text.toString()
                val answer4 = selectedValue

                if (answer1.isNotEmpty() && answer2.isNotEmpty() && answer3.isNotEmpty() && answer4.isNotEmpty()) {
                    val personSurvey = PersonSurveyInfo(person, answer1,answer2,answer3,answer4)
                    val intent = Intent(this@CustomActivity, ResultActivity::class.java)
                    intent.putExtra("personSurvey", personSurvey)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@CustomActivity, "Lütfen tüm soruları cevaplayın", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}