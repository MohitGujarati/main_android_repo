package mohit.dev.datepicker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var ct:Context,var itemdata:List<model_class>):ArrayAdapter<model_class>(ct,R.layout.row_view,itemdata)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var layoutinflater:LayoutInflater= LayoutInflater.from(ct)

        val view:View=layoutinflater.inflate(R.layout.row_view,null,true)

        var imview=view.findViewById<ImageView>(R.id.iv_image)
        var txtview=view.findViewById<TextView>(R.id.tv_data)


        var models:model_class=itemdata[position]
        imview.setImageResource(models.img)
        txtview.text=models.title

        return view
    }
}