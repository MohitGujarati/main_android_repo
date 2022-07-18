package mohit.dev.navigation_compo.navigation_compo2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.navigation_compo.R
import mohit.dev.navigation_compo.navigation_compo2.myHotel_model

class Adapter_Myhotel(var hotelarraylist:List<myHotel_model>) :
    RecyclerView.Adapter<Adapter_Myhotel.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.hotel_items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var mymodel = hotelarraylist[position]

        holder.himage.setImageResource(mymodel.img)
        holder.hname.text = mymodel.name
        holder.hprice.text = mymodel.price.toString()+"₹"
        holder.hlocation.text=mymodel.Location
        holder.hlocation.text=mymodel.Location
        holder.hdes.text=mymodel.Description
    }

    override fun getItemCount(): Int {
        return hotelarraylist.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var hname=ItemView.findViewById<TextView>(R.id.tv_Hotelname)
        var hlocation=ItemView.findViewById<TextView>(R.id.tv_Hotellocation)
        var hprice=ItemView.findViewById<TextView>(R.id.tv_Hotelprice)
        var himage=ItemView.findViewById<ImageView>(R.id.iv_hotelImage)
        var hdes=ItemView.findViewById<TextView>(R.id.tv_Hoteldes)


    }
}