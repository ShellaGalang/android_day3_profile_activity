package com.example.day2_miniprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.day2_miniprofile.databinding.FragmentProfileInfoBinding

// Fragment Class
class ProfileInfoFragment: Fragment() {

    // _binding: nullable variable that holds the fragment's layout views
    // Why use _binding? Because fragment views can be destroyed when the fragment is removed or replaced, and we need to avoid memory leaks.
    private var _binding: FragmentProfileInfoBinding? = null

    // binding non-nullable shortcut. !! means it is not null here. saves you from writing _binding!! all the time
    private val binding get() = _binding!!

    // Fragment creating its View
    override fun onCreateView(
        inflater: LayoutInflater, // convert the XML layout into actual View objects
        container: ViewGroup?, // parent layout where this fragment will be place
        savedInstanceState: Bundle?
    ): View {
        // connects the XML layout to the binding object to access views in Kotlin
        _binding = FragmentProfileInfoBinding.inflate(inflater, container, false)
        return binding.root // returns the root view of the fragment which is shown on screen
    }

    // Called after the view is created. Where we interact with UI Elements. Ui Setup
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // arguments is a bundle of data passed from MainActivity. Key in getString is the argument name
        val headerTitle = arguments?.getString("header_title")
        val profileInfo = arguments?.getString("profile_info")

        // Set the header and profile info text view
        binding.fragmentTitle.text = headerTitle
        binding.fragmentInfo.text = profileInfo

        // Fragment Back button behavior
        binding.btnBack.setOnClickListener {
            // removes this fragment and return to the previous screen
            parentFragmentManager.popBackStack()
        }
    }

    // Called when the fragment view is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // prevents memory leaks
    }


    // Companion Object, safely pass arguments to a fragment
    companion object {
        fun newInstance(headerTitle: String, profileInfo: String): ProfileInfoFragment {
            return ProfileInfoFragment().apply { // Configure the fragment before returning it
                arguments = Bundle().apply {
                    putString("header_title", headerTitle)
                    putString("profile_info", profileInfo)
                }
            }
        }
    }
}