package com.saugat.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saugat.finalassignment.R
import com.saugat.finalassignment.models.ItemMenu
import de.hdodenhof.circleimageview.CircleImageView

class ItemMenuAdapter
    (val lstItems : ArrayList<ItemMenu>, val context: Context)
    :RecyclerView.Adapter<ItemMenuAdapter.ItemViewHolder>()
{

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItemName: TextView
        val tvItemType: TextView
        val tvItemRating: TextView
        val tvItemPrice: TextView
        val itemImage: CircleImageView

        init {
            tvItemName = view.findViewById(R.id.tvItemName)
            tvItemType = view.findViewById(R.id.tvItemType)
            tvItemRating = view.findViewById(R.id.tvItemRating)
            tvItemPrice = view.findViewById(R.id.tvItemPrice)
            itemImage = view.findViewById(R.id.itemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.dashboard_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = lstItems[position]
        holder.tvItemName.text = item.itemName
        holder.tvItemName.text = item.itemName
        holder.tvItemName.text = item.itemName
        holder.tvItemName.text = item.itemName

        Glide.with(context)
            .load("https://chewnbrewjk.com/wp-content/uploads/2017/07/chicken-momos-1.jpg")
            .into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return lstItems.size
    }
}