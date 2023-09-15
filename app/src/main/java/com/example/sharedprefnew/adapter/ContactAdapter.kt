package com.example.sharedprefnew.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.sharedprefnew.models.Contact
import com.example.sharedprefnew.databinding.ItemContactsBinding

class ContactAdapter(var mContext: Context, contactList: List<Contact>) :
    BaseAdapter() {
    var contactList: List<Contact>

    init {
        this.contactList = contactList
    }

    override fun getCount(): Int {
        return contactList.size
    }

    override fun getItem(position: Int): Any {
        return contactList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: ItemContactsBinding

        binding = if (convertView == null) {
            ItemContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        } else {
            ItemContactsBinding.bind(convertView)
        }
//        val view: View =
//            LayoutInflater.from(mContext).inflate(R.layout.item_contacts, parent, false)
//        val name = view.findViewById<TextView>(R.id.contact_name)
//        val number = view.findViewById<TextView>(R.id.contact_number)
        val contact: Contact = getItem(position) as Contact
        binding.contactName.text = contact.name
        binding.contactNumber.text = contact.number
        return binding.root
    }
}