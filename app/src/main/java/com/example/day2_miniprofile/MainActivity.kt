package com.example.day2_miniprofile

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.day2_miniprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Shortcut to all views in activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // Open the app, create the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Loads activity_main.xml to binding and display it on screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back stack listener
        supportFragmentManager.addOnBackStackChangedListener {
            // Count fragments currently in the back stack
            val fragmentCount = supportFragmentManager.backStackEntryCount

            // If there are no fragments show the profile screen, hide the fragment container
            if (fragmentCount == 0) {
                binding.profileContent.visibility = View.VISIBLE
                binding.fragmentContainer.visibility = View.GONE
            }
        }

        // Call setupArrowClick for each arrow icon
        // Birthday Arrow
        setupArrowClick(
            binding.iconBirthdayArrow,
            getString(R.string.birthday_text),
            getString(R.string.birthday_value)
        )

        // Address Arrow
        setupArrowClick(
            binding.iconAddressArrow,
            getString(R.string.address_text),
            getString(R.string.address_value)
        )

        // Degree Arrow
        setupArrowClick(
            binding.iconDegreeArrow,
            getString(R.string.degree_text),
            getString(R.string.degree_value)
        )

        // Years in Service Arrow
        setupArrowClick(
            binding.iconYISArrow,
            getString(R.string.yis_text),
            getString(R.string.yis_value)
        )

        // Skills Arrow
        setupArrowClick(
            binding.iconSkillsArrow,
            getString(R.string.skills_text),
            getString(R.string.skills_value)
        )
    }

    // Helper function, setup arrow clicks
    private fun setupArrowClick(arrow: View, header: String, info: String){
        // When the arrow is clicked, open the fragment and pass data to it
        arrow.setOnClickListener{
            openFragment(header, info)
        }
    }

    // Open the profile info fragment
    private fun openFragment(headerTitle: String, profileInfo: String) {
        // Hide profile UI and show fragment UI
        binding.profileContent.visibility = View.GONE
        binding.fragmentContainer.visibility = View.VISIBLE

        // ProfileInfoFragment Operation
        supportFragmentManager.beginTransaction()
            // Put ProfileInfoFragment inside fragment_container
            .replace(
                binding.fragmentContainer.id,
                ProfileInfoFragment.newInstance(headerTitle, profileInfo)
            )
            .addToBackStack(null) // Remember the screen
            .commit() // Executes the transaction
    }
}