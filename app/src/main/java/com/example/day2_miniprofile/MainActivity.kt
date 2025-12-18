package com.example.day2_miniprofile

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Click button
        val hobbiesButton = findViewById<com.google.android.material.button.MaterialButton>(
            R.id.btnGoToHobbies
        )

        hobbiesButton.setOnClickListener {
            val intent = android.content.Intent(this, HobbyActivity::class.java)
            startActivity(intent)
        }

        // Birthday Toast
        val birthdayArrow = findViewById<ImageView>(R.id.iconBirthdayArrow)

        birthdayArrow.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.birthday_value),
                Toast.LENGTH_SHORT).show()
        }

        // Address Toast
        val addressArrow = findViewById<ImageView>(R.id.iconAddressArrow)

        addressArrow.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.address_value),
                Toast.LENGTH_SHORT).show()
        }

        // Degree Toast
        val degreeArrow = findViewById<ImageView>(R.id.iconDegreeArrow)

        degreeArrow.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.degree_value),
                Toast.LENGTH_SHORT).show()
        }

        // Years in Service Toast
        val yisArrow = findViewById<ImageView>(R.id.iconYISArrow)

        yisArrow.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.yis_value),
                Toast.LENGTH_SHORT).show()
        }

        // Skills Toast
        val skillsArrow = findViewById<ImageView>(R.id.iconSkillsArrow)

        skillsArrow.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.skills_value),
                Toast.LENGTH_LONG).show()
        }

    }
}