package mohit.dev.hotel_nav

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mohit.dev.navigation_compo.navigation_compo2.Adapter.Adapter_Myhotel
import mohit.dev.navigation_compo.navigation_compo2.myHotel_model


class navigate_hotel : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_navigate_hotel, container, false)

        var fabbtn=view.findViewById<FloatingActionButton>(R.id.go_back)

        var recview = view.findViewById<RecyclerView>(R.id.hotel_recview)

        loaddata(recview,view)

        fabbtn.setOnClickListener {
            fabclick(fabbtn,view)
        }


        return view
    }

    private fun fabclick(fabbtn: FloatingActionButton?,view: View) {
        var builder = AlertDialog.Builder(view.context)
            .setTitle("Alert")
            .setMessage("Are you sure you want to exit")
            .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(activity, "yes", Toast.LENGTH_SHORT).show()
                activity?.finish()
                dialog.dismiss()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            .setNeutralButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(activity, "cancel", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })
            .setCancelable(false)

        builder.show()

    }



    private fun loaddata(recview: RecyclerView,view: View) {

        recview.layoutManager = LinearLayoutManager(context)

        val hotel_arraylist = ArrayList<myHotel_model>()

        for (i in 1..8) {
            hotel_arraylist.add(
                myHotel_model(
                    "hotel $i",
                    "Location $i",
                    "Hello Description $i",
                    R.mipmap.hotel,
                    10000
                )
            )
        }


        //view.context
        var connect_Adapter = Adapter_Myhotel(hotel_arraylist)
        recview.adapter = connect_Adapter


    }



}