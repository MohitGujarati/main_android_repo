package mohit.dev.june17_recview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.june17_recview.Model.MyModel_class
import mohit.dev.june17_recview.R

class MyAdapter_class(var myarraylist:List<MyModel_class>)
    : RecyclerView.Adapter<MyAdapter_class.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.row_data,parent,false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var mymodel=myarraylist[position]

        holder.img.setImageResource(mymodel.img)
        holder.tv.setText(mymodel.title)
    }

    override fun getItemCount(): Int {
        return myarraylist.size
    }

    class ViewHolder (ItemView:View):RecyclerView.ViewHolder(ItemView){

        var img=itemView.findViewById<ImageView>(R.id.row_img)
        var tv=itemView.findViewById<TextView>(R.id.row_text)

    }
}