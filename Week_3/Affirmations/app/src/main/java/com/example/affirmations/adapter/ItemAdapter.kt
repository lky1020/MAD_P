package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

// Use to get the data and pass to the RecycleView
// Information in the app, all will be stored in Context
class ItemAdapter(private val context: Context,
                  private val dataset: List<Affirmation>
                  ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Used to hold the item views
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textview: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // Create nre view holder for the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Get the layout of the list_item.xml and return
        // LayoutInflater = turn the xml file into view hierarchies
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    // Replace the contents of a list item view
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textview.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource((item.imageResourceId))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}