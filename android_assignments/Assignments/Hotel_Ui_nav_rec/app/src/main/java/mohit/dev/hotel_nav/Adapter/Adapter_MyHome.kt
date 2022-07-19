package mohit.dev.hotel_nav.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.hotel_nav.R
import mohit.dev.navigation_compo.navigation_compo2.Adapter.Adapter_Myhotel
import mohit.dev.navigation_compo.navigation_compo2.myHome_model

class Adapter_MyHome(var homearraylist:List<myHome_model>)
    : RecyclerView.Adapter<Adapter_MyHome.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_MyHome.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.home_popularplace_items,parent,false)
        return Adapter_MyHome.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter_MyHome.ViewHolder, position: Int) {
        var mymodel = homearraylist[position]

        holder.hplaceimage.setImageResource(mymodel.img)
        holder.hplacename.text = mymodel.name
        holder.hplacerattings.text = mymodel.ratting.toString()
        holder.hlocation.text=mymodel.Location
      //  holder.hplacetag.text=mymodel.Tag
      //  holder.hplacetag2.text=mymodel.Tag2

    }

    override fun getItemCount(): Int {
       return homearraylist.size
    }

    class ViewHolder(Item:View):RecyclerView.ViewHolder(Item) {

        var hplacename=Item.findViewById<TextView>(R.id.tv_placename)
        var hlocation=Item.findViewById<TextView>(R.id.tv_location)
        var hplacerattings=Item.findViewById<TextView>(R.id.tv_start)
        var hplaceimage=Item.findViewById<ImageView>(R.id.iv_place_Image)
       // var hplacetag=Item.findViewById<TextView>(R.id.tv_tags)
       // var hplacetag2=Item.findViewById<TextView>(R.id.tv_tags2)

    }
}