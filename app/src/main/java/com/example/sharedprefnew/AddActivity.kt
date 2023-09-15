package com.example.sharedprefnew

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefnew.databinding.ActivityAddBinding
import com.example.sharedprefnew.models.Contact
import com.example.sharedprefnew.singleton.MyGson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()
    private var contactList = ArrayList<Contact>()

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = this.getSharedPreferences("Hello", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        binding.contactAddBtn.setOnClickListener {
            if (isValid()) {
                val name = binding.contactNameAdd.text.toString()
                val number = binding.contactNumberAdd.text.toString()
                val contact = Contact(name, number)
                val contactJsonString = sharedPreferences.getString("contact", "")
                val type = object : TypeToken<ArrayList<Contact>>() {}.type
                val contactList1: Contact? = MyGson.instance.gson!!.fromJson<Contact>(contactJsonString, type)

                contactList.add(contact)
                val jsonString = gson.toJson(contactList)
                editor.putString("contact", jsonString)
                editor.commit()
                this.finish()

            }
        }


    }

    private fun isValid(): Boolean {
        if (binding.contactNameAdd.text.toString().isEmpty()) {
            Toast.makeText(this, "Name kiritilmagan", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.contactNumberAdd.text.toString().isEmpty()) {
            Toast.makeText(this, "Nomer kiritilmagan", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}