package com.saugat.finalassignment.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.ui.ItemData
import com.saugat.finalassignment.R
import com.saugat.finalassignment.adapters.ItemMenuAdapter
import com.saugat.finalassignment.models.Item


class HomeFragment : Fragment() {
    private val lstItems = ArrayList<Item>()
    private lateinit var recyclerViewDashboard: RecyclerView
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerViewDashboard = view.findViewById(R.id.recyclerViewDashboard)

        if (ItemData.get().list().size == 0){
            loadItems()
        }

        val adapter = ItemMenuAdapter(ItemData.get().list(),context!!)
        recyclerViewDashboard.layoutManager = LinearLayoutManager(activity)
        recyclerViewDashboard.adapter = adapter

        return view
    }

    private fun loadItems() {
        ItemData.get().list().add(Item(i++,"Chicken MoMo","Non-Veg",4.5F,200))
        ItemData.get().list().add(Item(i++,"Veg MoMo","Veg",4F,120))
        ItemData.get().list().add(Item(i++,"Jhol MoMo","Non-Veg",4.7F,250))
    }

}