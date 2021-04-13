package com.saugat.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.entity.Item

class CartAdapter(private val lstItems: ArrayList<Item>, val context: Context)
    : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val foodName: TextView = view.findViewById(R.id.foodName)
        val foodPrice: TextView = view.findViewById(R.id.foodPrice)
        val foodImage: ImageView = view.findViewById(R.id.foodImage)
        val delete: ImageButton = view.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_layout, parent, false)
        return CartViewHolder(view)

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val user = lstItems[position]

    }

    override fun getItemCount(): Int {
        return lstItems.size
    }
}
