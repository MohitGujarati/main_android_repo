package mohit.dev.zomato_clone.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.*
import mohit.dev.zomato_clone.View.Detail_Activity

class MyDining_Adapter(var context: Context, var DiningArraylist: List<Dining_ModelClass>) :
    RecyclerView.Adapter<MyDining_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_dining_placeitems, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mymodel = DiningArraylist[position]

        holder.hotel_name.text = mymodel.Rest_name
        holder.hotel_location.text = mymodel.Rest_loc
        holder.hotel_ratting.text = mymodel.Rest_ratting.toString()
        holder.hotel_price.text = "₹" + mymodel.Rest_price.toString() + "/-For Two"
        holder.hotel_image.setImageResource(mymodel.Rest_image)


        holder.hotel_card.setOnClickListener {

            val bundle=Bundle()

            val loc = Intent(context, Detail_Activity::class.java)
            loc.putExtra("name", mymodel.Rest_name)
            loc.putExtra("price", mymodel.Rest_price.toString())
            loc.putExtra("location", mymodel.Rest_loc)
            loc.putExtra("ratting", mymodel.Rest_ratting.toString())
            loc.putExtra("Img", mymodel.Rest_image)
            loc.putExtra("detail_loc",mymodel.Rest_detailLocation)


            context.startActivity(loc)
//            var i=Intent(context,Detail_Activity::class.java)
//            bundle.putString("data",holder.hotel_name.text.toString())
//            Toast.makeText(context, "Done Move to next act ", Toast.LENGTH_SHORT).show()
//

        }
    }

    override fun getItemCount(): Int {
        return DiningArraylist.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var hotel_name = itemView.findViewById<TextView>(R.id.tv_Hotelname)
        var hotel_location = itemView.findViewById<TextView>(R.id.tv_Hotellocation)
        var hotel_price = itemView.findViewById<TextView>(R.id.tv_Hotelprice)
        var hotel_ratting = itemView.findViewById<TextView>(R.id.tv_Hotelratting)
        var hotel_image = itemView.findViewById<ImageView>(R.id.iv_HotelImage)

        var hotel_card=itemView.findViewById<CardView>(R.id.container_card)
    }
}