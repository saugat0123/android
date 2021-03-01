package com.saugat.finalassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saugat.finalassignment.R
import com.saugat.finalassignment.entity.UserLocal

class ProfileAdapter(private val lstUserLocal: MutableList<UserLocal>) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

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
        val userlocal = lstUserLocal[position]
        holder.fname.text = userlocal.firstName
        holder.lname.text = userlocal.lastName
        holder.phone.text = userlocal.phone
        holder.address.text = userlocal.address
        holder.email.text = userlocal.email
    }

    override fun getItemCount(): Int {
        return lstUserLocal.size
    }
}
