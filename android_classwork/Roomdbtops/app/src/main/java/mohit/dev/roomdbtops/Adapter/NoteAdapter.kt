package mohit.dev.roomdbtops.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.google.android.material.navigation.NavigationView
import mohit.dev.roomdbtops.Note
import mohit.dev.roomdbtops.R

class NoteAdapter(val onItemSelectedListener: (Note) -> Unit) : ListAdapter<Note, NoteAdapter.NoteHolder>(diffCallback) {

    inner class NoteHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val des = itemView.findViewById<TextView>(R.id.tv_Des)
        val prioity = itemView.findViewById<TextView>(R.id.tv_priority)

        init {


            itemView.setOnClickListener {

                if (adapterPosition!= NO_POSITION)
                    onItemSelectedListener(getItem(adapterPosition))

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {

        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.layout_viewdata,parent,false)
        return NoteHolder(itemview)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {

        with(getItem(position)){
            holder.title.text=title
            holder.des.text=des
            holder.prioity.text=priority.toString()
        }

    }

    fun  getNoteAt(position: Int)=getItem(position)


}

val diffCallback = object : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) =
        oldItem.title == newItem.title && oldItem.des == newItem.des && oldItem.priority == newItem.priority
}

