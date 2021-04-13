package com.saugat.finalassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.adapters.ItemsAdapter
import com.saugat.finalassignment.entity.Item


class CartFragment : Fragment() {

    private lateinit var recyclerViewCart: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        recyclerViewCart = view.findViewById(R.id.recyclerViewCart)

//        val adapter = CartFragment(lstItems as ArrayList<Item>, requireActivity())
//        recyclerViewCart.layoutManager = LinearLayoutManager(requireActivity())
//        recyclerViewCart.adapter = adapter

        return view
    }

}