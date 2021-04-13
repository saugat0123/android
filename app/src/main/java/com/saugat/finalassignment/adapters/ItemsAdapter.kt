package com.saugat.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saugat.finalassignment.R

import com.saugat.finalassignment.entity.Item
import com.saugat.rblibrary.api.ServiceBuilder

class ItemsAdapter(private val lstItems: ArrayList<Item>,
                   val context: Context)
    :RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>()
{

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
        val itemPrice: TextView = view.findViewById(R.id.itemPrice)
        val itemImg: ImageView = view.findViewById(R.id.itemImg)
//        val addToCart: ImageView = view.findViewById(R.id.addToCart)
//        val like: ImageView = view.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = lstItems[position]
        holder.itemName.text = item.itemName
        holder.itemPrice.text = item.itemPrice.toString()


        val imagePath = ServiceBuilder.loadImagePath() + item.photo
        if (!item.photo.equals("no-photo.jpg")) {
            Glide.with(context)
                    .load(imagePath)
                    .fitCenter()
                    .into(holder.itemImg)
        }

//        holder.addToCart.setOnClickListener {
//
////            val intent = Intent(context, CartFragment::class.java)
////            var bundle = Bundle()
////            bundle.putParcelable("item", item)
////            intent.putExtra("myBundle", bundle)
////            Toast.makeText(context, "${item.itemName} added to Cart!!", Toast.LENGTH_SHORT).show()
////            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return lstItems.size
    }
}