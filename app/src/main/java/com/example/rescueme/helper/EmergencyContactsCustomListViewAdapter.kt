package com.example.rescueme.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.rescueme.R
import com.example.rescueme.data.EmergencyContact

class EmergencyContactsCustomListViewAdapter(private val context: Context, private val emergencyContactList: List<EmergencyContact>): BaseAdapter() {
    override fun getCount(): Int = emergencyContactList.size
    override fun getItem(position: Int): Any = emergencyContactList[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.act_emergencycontact_item_custom_list_view, parent, false)
        val imageviewItemPic = view.findViewById<ImageView>(R.id.imageview_item_pic)
        val emergencycontactName = view.findViewById<TextView>(R.id.textview_emergencycontactname)
        val emergencycontactNumber = view.findViewById<TextView>(R.id.textview_emergencycontactnumber)

        val emergencyContact = emergencyContactList[position]

        imageviewItemPic.setImageResource(emergencyContact.photoRes)
        emergencycontactName.setText("${emergencyContact.emergencycontactname}")
        emergencycontactNumber.setText("${emergencyContact.emergencycontactnumber}")

        return view
    }
}