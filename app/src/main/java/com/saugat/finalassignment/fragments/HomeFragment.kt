package com.saugat.finalassignment.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.adapters.ItemMenuAdapter
import com.saugat.finalassignment.entity.Item
import com.saugat.finalassignment.repository.ItemRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    private lateinit var recyclerViewDashboard: RecyclerView

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

        loadItems()

        return view
    }

    private fun loadItems() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val itemRepo = ItemRepo()
                val response = itemRepo.getAllItems()
                if (response.success == true){
                    val lstItems = response.data
                    withContext(Dispatchers.Main){
                        val adapter = context?.let { ItemMenuAdapter(lstItems as ArrayList<Item>, it) }
                        recyclerViewDashboard.layoutManager = LinearLayoutManager(context)
                        recyclerViewDashboard.adapter = adapter
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(activity,
                            "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}