package com.saugat.finalassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.ItemData
import com.saugat.finalassignment.R
import com.saugat.finalassignment.adapters.ItemMenuAdapter
import com.saugat.finalassignment.models.ItemMenu


class HomeFragment : Fragment() {
    private val lstItems = ArrayList<ItemMenu>()
    private lateinit var recyclerViewDashboard: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerViewDashboard = view.findViewById(R.id.recyclerViewDashboard)

        val adapter = ItemMenuAdapter(ItemData.get().list(),requireContext())
        recyclerViewDashboard.layoutManager = LinearLayoutManager(activity)
        recyclerViewDashboard.adapter = adapter

        return view
    }

}