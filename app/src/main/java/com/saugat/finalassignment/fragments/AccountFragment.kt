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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.adapters.ProfileAdapter
import com.saugat.finalassignment.db.RB_DB
import com.saugat.finalassignment.ui.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AccountFragment : Fragment() {

    private lateinit var btnLogout: Button
    private lateinit var sharedPref: SharedPreferences
    private lateinit var recyclerViewProfile: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //@SuppressLint("UseRequireInsteadOfGet", "CommitPrefEdits")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_account, container, false)

        btnLogout = view.findViewById(R.id.btnLogout)
        recyclerViewProfile = view.findViewById(R.id.recyclerViewProfile)
        sharedPref = requireContext().getSharedPreferences("MyPref",MODE_PRIVATE)

//        arguments?.getString("emailOfUser")
        val args = arguments
        val email = args?.getString("emailOfUser")

        CoroutineScope(Dispatchers.IO).launch{
            val lstUser =
                    context?.let {
                        if (email != null) {
                            RB_DB.getInstance(it)
                                    .getUserDAO().getUser(email)
                        }
                    }
            withContext(Dispatchers.Main){
               // recyclerViewProfile.adapter =  ProfileAdapter(lstUser)
                recyclerViewProfile.layoutManager = LinearLayoutManager(activity)
            }
        }

        btnLogout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(requireContext(),LoginActivity::class.java))
        }

        return view
    }
}