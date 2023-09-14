package com.example.sharedprefnew

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.sharedprefnew.databinding.ActivityAddBinding
import com.google.gson.Gson

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

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
                val jsonString = gson.toJson(contact).toString()
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