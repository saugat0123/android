package com.saugat.finalassignment.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import com.bumptech.glide.Glide
import com.saugat.finalassignment.R
import com.saugat.finalassignment.api.ServiceBuilder
import com.saugat.finalassignment.repository.UserRepo
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfileFragment : Fragment() {

    private lateinit var profilePic: CircleImageView
    private lateinit var fName: EditText
    private lateinit var lName: EditText
    private lateinit var address: EditText
    private lateinit var email: EditText
//    private lateinit var password: EditText
    private lateinit var phone: EditText
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profilePic = view.findViewById(R.id.profilePic)
        fName = view.findViewById(R.id.fName)
        lName = view.findViewById(R.id.lName)
        address = view.findViewById(R.id.address)
        email = view.findViewById(R.id.email)
//        password = view.findViewById(R.id.password)
        phone = view.findViewById(R.id.phone)
        btnUpdate = view.findViewById(R.id.btnUpdate)

        loadAllUserDetails()

        profilePic.setOnClickListener {
            loadPopupMenu()
        }

        btnUpdate.setOnClickListener {
            updateDetails()
        }

        return view
    }

    private fun updateDetails() {

    }

    private fun loadAllUserDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val userRepo = UserRepo()
                val response = userRepo.getMe()
                if (response.success == true){
                    val imagePath = ServiceBuilder.loadImagePath() + response.data?.photo
                    withContext(Dispatchers.Main){
                        Glide.with(requireContext())
                            .load(imagePath)
                            .fitCenter()
                            .into(profilePic)

                        fName.setText(response.data?.firstName)
                        lName.setText(response.data?.lastName)
                        address.setText(response.data?.address)
                        email.setText(response.data?.email)
                        phone.setText(response.data?.phone)
//                        password.setText(response.data?.password)

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

    private var REQUEST_GALLERY_CODE = 3
    private var REQUEST_CAMERA_CODE = 2
    private var imageURL: String? = null

    private fun loadPopupMenu() {
        val popupMenu = PopupMenu(requireActivity(), profilePic)
        popupMenu.menuInflater.inflate(R.menu.gallery_camera, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menuCamera ->
                    openCamera()
                R.id.menuGallery ->
                    openGallery()
            }
            true
        }
        popupMenu.show()
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_GALLERY_CODE)
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CAMERA_CODE)
    }

}