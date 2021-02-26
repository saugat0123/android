package com.saugat.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.entity.Item
import de.hdodenhof.circleimageview.CircleImageView

class ItemMenuAdapter(private val lstItems: ArrayList<Item>,
                      val context: Context)
    :RecyclerView.Adapter<ItemMenuAdapter.ItemViewHolder>()
{

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItemName: TextView = view.findViewById(R.id.tvItemName)
        val tvItemType: TextView = view.findViewById(R.id.tvItemType)
        val tvItemRating: TextView = view.findViewById(R.id.tvItemRating)
        val tvItemPrice: TextView = view.findViewById(R.id.tvItemPrice)
        val itemImage: CircleImageView = view.findViewById(R.id.itemImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.dashboard_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = lstItems[position]
        holder.tvItemName.text = item.itemName
        holder.tvItemType.text = item.itemType
        holder.tvItemRating.text = item.itemRating.toString()
        holder.tvItemPrice.text = item.itemPrice.toString()

    }

    override fun getItemCount(): Int {
        return lstItems.size
    }
}