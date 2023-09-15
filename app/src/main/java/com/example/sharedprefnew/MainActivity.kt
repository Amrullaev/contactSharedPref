package com.example.sharedprefnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedprefnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contactAdd.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }

        binding.contactList.setOnClickListener {
            startActivity(Intent(this, AllContactsJavaActivity::class.java))
        }
    }
}