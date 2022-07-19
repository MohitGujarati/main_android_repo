package mohit.dev.hotel_nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.hotel_nav.Adapter.Adapter_MyHome
import mohit.dev.navigation_compo.navigation_compo2.myHome_model

class navigate_home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view=inflater.inflate(R.layout.fragment_navigate_home, container, false)

       var recview=view.findViewById<RecyclerView>(R.id.home_recview)

       loaddata(recview)

        return view
    }

    private fun loaddata(recview: RecyclerView) {

        recview.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))

    //    recview.layoutManager=LinearLayoutManager(context)

        val home_arraylist=ArrayList<myHome_model>()

        for (i in 1..8) {
            home_arraylist.add(
                myHome_model(
                    "Place $i",
                    "Location $i",
                    "tag $i",
                    "tag $i",
                    R.mipmap.places,
                    5.0

                )
            )
        }


        var connect_Adapter=Adapter_MyHome(home_arraylist)
        recview.adapter=connect_Adapter


    }
}