package mohit.dev.navigation_compo.navigation_compo2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.navigation_compo.R
import mohit.dev.navigation_compo.navigation_compo2.Adapter.Adapter_Myhotel
import mohit.dev.navigation_compo.navigation_compo2.myHotel_model


class Hotel_nav_frag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_hotel_nav_frag, container, false)

        var hotel_recview = v.findViewById<RecyclerView>(R.id.rec_hotel)

        loadHoteldetail(hotel_recview)
        return v
    }

    private fun loadHoteldetail(hotelRecview: RecyclerView) {
        hotelRecview.layoutManager = GridLayoutManager(context, 4)

        val hotel_arrayList = ArrayList<myHotel_model>()

        for (i in 1..8) {
            hotel_arrayList.add(
                myHotel_model(
                    "hotel $i",
                    "Location $i",
                    "Hello",
                    R.drawable.ic_category,
                    10000
                )
            )
        }
        var MyCategory_Adapter = Adapter_Myhotel(hotel_arrayList)
        hotelRecview.adapter = MyCategory_Adapter

    }
}