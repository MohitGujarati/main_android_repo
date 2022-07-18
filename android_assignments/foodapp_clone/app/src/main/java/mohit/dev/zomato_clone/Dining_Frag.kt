package mohit.dev.zomato_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Adapter.MyDining_Adapter
import mohit.dev.zomato_clone.Adapter.MyHome_Adapter
import mohit.dev.zomato_clone.Adapter.MyHotel_Adapter


class Dining_Frag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dining_, container, false)

        var dining_recview = view.findViewById<RecyclerView>(R.id.hotel_recview)
        var popular_recview = view.findViewById<RecyclerView>(R.id.popular_recview)
        var Hotel_recview = view.findViewById<RecyclerView>(R.id.rec_hotelAround)

        //  var v= view.findNavController()
        load_Diningdata(dining_recview, view)
        load_Populardata(popular_recview, view)
        load_hotelData(Hotel_recview, view)


        return view
    }

    private fun load_hotelData(hotelRecview: RecyclerView, view: View) {

        hotelRecview.layoutManager = LinearLayoutManager(context)

        val hotelArraylist = ArrayList<Hotel_ModelClass>()

        for (i in 1..8) {
            hotelArraylist.add(
                Hotel_ModelClass(
                    R.drawable.hotel,
                    "Hotel $i",
                    5.0
                )
            )
            hotelArraylist.add(
                Hotel_ModelClass(
                    R.drawable.hotel,
                    "Hotel $i",
                    4.5
                )
            )


            //view.context
            var connect_Adapter = MyHotel_Adapter(view.context, hotelArraylist)
            hotelRecview.adapter = connect_Adapter
        }
    }

    private fun load_Diningdata(diningrecview: RecyclerView, view: View) {
        diningrecview.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )

        val Dining_arraylist = ArrayList<Dining_ModelClass>()

        for (i in 1..8) {
            Dining_arraylist.add(
                Dining_ModelClass(
                    "Restaurants $i",
                    "10Km",
                    "Gandhinagar,Sector-26,above RailwayStation,Pincode - 382026",
                    5.0,
                    1200,
                    R.drawable.res_1,

                )
            )
            Dining_arraylist.add(
                Dining_ModelClass(
                    "Restaurants $i",
                    "15Km ",
                    "Gandhinagar,Sector-26,above RailwayStation,Pincode - 382026",
                    5.0,
                    1200,
                    R.drawable.res_2,

                )
            )
        }


        //view.context
        var connect_Adapter = MyDining_Adapter(view.context, Dining_arraylist)
        diningrecview.adapter = connect_Adapter


    }

    private fun load_Populardata(popularRecview: RecyclerView, view: View) {
        // popularRecview.setLayoutManager(LinearLayoutManager(context))

        popularRecview.layoutManager = GridLayoutManager(context, 2)
        val popular_arraylist = ArrayList<product_ModelClass>()

        for (i in 1..8) {
            popular_arraylist.add(
                product_ModelClass(
                    R.drawable.burger,
                    "This is Pasta $i",
                    "3.0",
                    "listview item $i",
                    "450",
                    "30",
                    2,
                    10,

                    )
            )
        }


        //view.context
        var connect_Adapter = MyHome_Adapter(popular_arraylist)
        popularRecview.adapter = connect_Adapter


    }

}