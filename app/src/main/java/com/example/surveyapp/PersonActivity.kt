package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.surveyapp.R
import com.example.surveyapp.databinding.ActivityPersonBinding
import com.example.surveyapp.model.Person

class PersonActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val upperName = name?.uppercase()

        with(binding) {
            tvName.setText("Hoşgeldin $upperName")

            btnSave.setOnClickListener {
                val name = upperName
                val age = etAge.text.toString()
                val city = etCity.text.toString()
                val country = etCountry.text.toString()
                val email = etMail.text.toString()

                if (name!!.isNotEmpty() && age.isNotEmpty() && city.isNotEmpty() && country.isNotEmpty() && email.isNotEmpty()) {
                    val person = Person(name,age.toInt(),city,country,email)
                    val intent = Intent(this@PersonActivity, CustomActivity::class.java)
                    intent.putExtra("person", person)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@PersonActivity, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}