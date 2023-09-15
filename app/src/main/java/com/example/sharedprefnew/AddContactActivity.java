package com.example.sharedprefnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedprefnew.databinding.ActivityAddBinding;
import com.example.sharedprefnew.databinding.ActivityAddContactBinding;
import com.example.sharedprefnew.models.Contact;
import com.example.sharedprefnew.singleton.MyGsonJava;
import com.example.sharedprefnew.utils.SharedPref;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddContactActivity extends AppCompatActivity {
    private ActivityAddContactBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("new_contact", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.contactAddBtn.setOnClickListener(v -> {
            if (isValid()) {
                String contactName = binding.contactNameAdd.getText().toString();
                String contactNumber = binding.contactNumberAdd.getText().toString();
                Contact contact = new Contact(contactName, contactNumber);

                String contactJsonString = sharedPreferences.getString("new_contacts", "");
                List<Contact> contactList;
                if (contactJsonString.equals("")) {
                    contactList = new ArrayList<>();
                } else {
                    Type type = new TypeToken<List<Contact>>() {
                    }.getType();
                    contactList = MyGsonJava.getInstance().getGson().fromJson(contactJsonString, type);

                }
                contactList.add(contact);
                String jsonString = MyGsonJava.getInstance().getGson().toJson(contactList);
                editor.putString("new_contacts", jsonString).commit();
                this.finish();

            }
        });
    }

    private boolean isValid() {
        if (binding.contactNameAdd.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ism yo'q", Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.contactNumberAdd.getText().toString().isEmpty()) {
            Toast.makeText(this, "momer yo'q", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


}