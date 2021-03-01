package com.saugat.finalassignment.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.saugat.finalassignment.R
import com.saugat.finalassignment.ui.LoginActivity


class AccountFragment : Fragment() {

    private lateinit var btnLogout: Button
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //@SuppressLint("UseRequireInsteadOfGet", "CommitPrefEdits")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_account, container, false)

        btnLogout = view.findViewById(R.id.btnLogout)
        sharedPref = requireContext().getSharedPreferences("MyPref",MODE_PRIVATE)



        btnLogout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(requireContext(),LoginActivity::class.java))
        }

        return view
    }
}