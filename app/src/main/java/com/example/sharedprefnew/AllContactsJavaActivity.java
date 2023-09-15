package com.example.sharedprefnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sharedprefnew.adapter.ContactAdapter;
import com.example.sharedprefnew.databinding.ActivityAllContactsJavaBinding;
import com.example.sharedprefnew.models.Contact;
import com.example.sharedprefnew.singleton.MyGsonJava;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllContactsJavaActivity extends AppCompatActivity {
    private ActivityAllContactsJavaBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllContactsJavaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("new_contact", MODE_PRIVATE);
        String contactJsonString = sharedPreferences.getString("new_contacts", "");
        List<Contact> contactList;
        if (contactJsonString.equals("")) {
            Toast.makeText(this, "Ro'yxat bo'sh", Toast.LENGTH_SHORT).show();
            contactList = new ArrayList<>();
        } else {
            Type type = new TypeToken<List<Contact>>() {
            }.getType();

            contactList = MyGsonJava.getInstance().getGson().fromJson(contactJsonString, type);
        }

        ContactAdapter contactAdapter = new ContactAdapter(this, contactList);
        binding.listView.setAdapter(contactAdapter);
    }
}