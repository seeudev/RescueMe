package com.example.rescueme.helper;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rescueme.data.EmergencyContact;
import android.view.LayoutInflater;
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rescueme.R
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder

class EmergencyContactsRecyclerViewAdapter(
    private val listOfEmergencyContacts: List<EmergencyContact>,
    private val onClick: (EmergencyContact)-> Unit,
    private val onLongClick: (EmergencyContact)-> Unit
): RecyclerView.Adapter<EmergencyContactsRecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val photo = view.findViewById<ImageView>(R.id.imageview_item_pic)
        val emergencyContactName = view.findViewById<TextView>(R.id.textview_emergencycontactname)
        val emergencyContactNumber = view.findViewById<TextView>(R.id.textview_emergencycontactnumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emergencycontact_item_recycler_view,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfEmergencyContacts.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listOfEmergencyContacts[position]

        holder.photo.setImageResource(item.photoRes)
        holder.emergencyContactName.setText(item.emergencycontactname)
        holder.emergencyContactNumber.setText(item.emergencycontactnumber)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
        holder.itemView.setOnLongClickListener {
            onLongClick(item)
            true
        }
    }

}
