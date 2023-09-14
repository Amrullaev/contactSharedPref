package com.example.sharedprefnew

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedprefnew.adapter.ContactAdapter
import com.example.sharedprefnew.databinding.ActivityAllContactsBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AllContactsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllContactsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()
    private val typeToken = object : TypeToken<Contact>() {}.type
    private val TAG = "AllContactsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences("Hello", MODE_PRIVATE)
        val contactList = ArrayList<Contact>()

        val jsonUser = sharedPreferences.getString("contact", "")
        val contact = gson.fromJson<Contact>(jsonUser, typeToken)
        contactList.add(contact)
        Log.d(TAG, "onCreate: $contactList")

        val contactAdapter = ContactAdapter(this, contactList)
        binding.listView.adapter = contactAdapter

    }
}