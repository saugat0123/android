package com.saugat.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.entity.User

class ProfileAdapter(private val lstUser: ArrayList<User>, val context: Context)
    : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val fname: TextView = view.findViewById(R.id.etFirstName)
        val lname: TextView = view.findViewById(R.id.etLastName)
        val phone: TextView = view.findViewById(R.id.etPhone)
        val address: TextView = view.findViewById(R.id.etAddress)
        val email: TextView = view.findViewById(R.id.etEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val user = lstUser[position]
        holder.fname.text = user.firstName
        holder.lname.text = user.lastName
        holder.phone.text = user.phone
        holder.address.text = user.address
        holder.email.text = user.email
    }

    override fun getItemCount(): Int {
        return lstUser.size
    }
}
