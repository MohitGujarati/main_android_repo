package mohit.dev.navigation_compo.navigation_compo2.Adapter

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.hotel_nav.R

import mohit.dev.navigation_compo.navigation_compo2.myHotel_model
import java.util.*
//var context: Context
class Adapter_Myhotel( var hotelarraylist: List<myHotel_model>) :
    RecyclerView.Adapter<Adapter_Myhotel.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.hotel_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var mymodel = hotelarraylist[position]

        holder.himage.setImageResource(mymodel.img)
        holder.hname.text = mymodel.name
        holder.hprice.text = "Price :-" + mymodel.price.toString() + "₹ /night"
        holder.hlocation.text = mymodel.Location
        holder.hlocation.text = mymodel.Location
        holder.hdes.text = mymodel.Description

        holder.hdatepicker_1.setOnClickListener {
       //     showdatecalender(holder.hdatepicker_1, holder.hdatepicker_2, true)
        }
        holder.hdatepicker_2.setOnClickListener {
        //    showdatecalender(holder.hdatepicker_1, holder.hdatepicker_2, false)
        }
    }

/*
    private fun showdatecalender(hdatepicker1: TextView?, hdatepicker2: TextView?, flag: Boolean) {
        var Todaydate = Calendar.getInstance()
        var year = Todaydate.get(Calendar.YEAR)
        var month = Todaydate.get(Calendar.MONTH)
        var day = Todaydate.get(Calendar.DAY_OF_MONTH)

        var datepickerbox =
            DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, month, d ->
                var m = month + 1
                if (flag == true) {
                    hdatepicker1!!.text = "$d / $month /$year "
                } else if (flag == false) {
                    hdatepicker2!!.text = "$d/ $month /$year  "
                }
            }, year, month, day)
                .show()
    }


 */


    override fun getItemCount(): Int {
        return hotelarraylist.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var hname = ItemView.findViewById<TextView>(R.id.tv_Hotelname)
        var hlocation = ItemView.findViewById<TextView>(R.id.tv_Hotellocation)
        var hprice = ItemView.findViewById<TextView>(R.id.tv_Hotelprice)
        var himage = ItemView.findViewById<ImageView>(R.id.iv_place_Image)
        var hdes = ItemView.findViewById<TextView>(R.id.tv_Hoteldes)
        var hdatepicker_1 = ItemView.findViewById<TextView>(R.id.btn_pickdater_1)
        var hdatepicker_2 = ItemView.findViewById<TextView>(R.id.btn_pickdater_2)


    }
}