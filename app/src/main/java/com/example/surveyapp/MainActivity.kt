package com.example.surveyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.surveyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRegister.setOnClickListener {
                val name = etName.text.toString()
                val fragment = PersonActivity()
                if (name.isNotEmpty()) {
                    val intent = Intent(this@MainActivity, PersonActivity::class.java)
                    intent.putExtra("name", name)
                    startActivity(intent)
                } else  {
                    Toast.makeText(this@MainActivity, "Lütfen Ad-Soyad bilgisini girin", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}