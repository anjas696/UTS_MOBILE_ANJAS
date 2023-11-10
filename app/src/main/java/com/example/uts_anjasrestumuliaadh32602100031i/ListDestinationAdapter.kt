package com.example.uts_anjasrestumuliaadh32602100031i

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDestinationAdapter (private val listDestination: ArrayList<Destination>) : RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>()  {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_destination, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listDestination[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        //holder.tvKeterangan.text = keterangan

        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listDestination[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listDestination.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        //val tvKeterangan: TextView = itemView.findViewById(R.id.tv_detail_keterangan)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Destination)
    }
}