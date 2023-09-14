package com.example.sharedprefnew.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.sharedprefnew.Contact
import com.example.sharedprefnew.R

class ContactAdapter(var mContext: Context, contactList: ArrayList<Contact>) :
    BaseAdapter() {
    var contactList: ArrayList<Contact>

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
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.item_contacts, parent, false)
        val name = view.findViewById<TextView>(R.id.contact_name)
        val number = view.findViewById<TextView>(R.id.contact_number)
        val contact: Contact = getItem(position) as Contact
        name.text = contact.name
        number.text = contact.number
        return view
    }
}