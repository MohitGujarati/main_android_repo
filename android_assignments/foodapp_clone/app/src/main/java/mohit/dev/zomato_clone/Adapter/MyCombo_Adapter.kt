package mohit.dev.zomato_clone.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Combo_ModelClass
import mohit.dev.zomato_clone.R

class MyCombo_Adapter(var comboArraylist:List<Combo_ModelClass>)
    :RecyclerView.Adapter<MyCombo_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCombo_Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_combolist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCombo_Adapter.ViewHolder, position: Int) {

        var mymodel=comboArraylist[position]

        holder.img.setImageResource(mymodel.combo_img)
    }


    override fun getItemCount(): Int {
        return comboArraylist.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var img=itemView.findViewById<ImageView>(R.id.combo_image)

    }

}