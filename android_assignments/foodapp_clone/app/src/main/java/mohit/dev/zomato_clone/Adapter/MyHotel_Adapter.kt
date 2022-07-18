package mohit.dev.zomato_clone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Hotel_ModelClass
import mohit.dev.zomato_clone.R

class MyHotel_Adapter(var context: Context,var hotel_Arraylist:List<Hotel_ModelClass>):
    RecyclerView.Adapter<MyHotel_Adapter.HotelViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHotel_Adapter.HotelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_dining_hotel, parent, false)
        return MyHotel_Adapter.HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyHotel_Adapter.HotelViewHolder, position: Int) {
        var mymodel=hotel_Arraylist[position]

        holder.img.setImageResource(mymodel.hotel_img)
        holder.title.setText(mymodel.hotel_name)
        holder.ratting.setText(mymodel.hotel_ratting.toString())
    }

    override fun getItemCount(): Int {
        return hotel_Arraylist.size
    }

    class HotelViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var img = itemView.findViewById<ImageView>(R.id.iv_place_Image)
        var title = itemView.findViewById<TextView>(R.id.tv_Hotelname)
        var ratting=itemView.findViewById<TextView>(R.id.hotel_ratting)

    }
}