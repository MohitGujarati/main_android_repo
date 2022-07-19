package mohit.dev.zomato_clone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Category_ModelClass
import mohit.dev.zomato_clone.R
import androidx.navigation.Navigation.findNavController as findNavController1

//var context: Context
class MyCategory_Adapter(var context: Context,var cat_Arraylist: List<Category_ModelClass>) :
    RecyclerView.Adapter<MyCategory_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_categorylistitems, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var mymodel = cat_Arraylist[position]

        holder.img?.setImageResource(mymodel.cat_img)
        holder.title?.text = mymodel.cat_title


        holder.img!!.setOnClickListener {
            Toast.makeText(context, "${holder.title!!.text}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return cat_Arraylist.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var img: ImageView? = itemView.findViewById<ImageView>(R.id.cat_img)
        var title: TextView? = itemView.findViewById<TextView>(R.id.cat_title)

    }
}