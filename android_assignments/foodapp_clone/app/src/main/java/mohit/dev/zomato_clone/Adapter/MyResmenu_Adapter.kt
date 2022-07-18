package mohit.dev.zomato_clone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Menu_ModelClass
import mohit.dev.zomato_clone.R

class MyResmenu_Adapter(var context: Context,var menuArraylist:List<Menu_ModelClass>)
    : RecyclerView.Adapter<MyResmenu_Adapter.Menu_ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyResmenu_Adapter.Menu_ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_resturant_menu, parent, false)
        return MyResmenu_Adapter.Menu_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyResmenu_Adapter.Menu_ViewHolder, position: Int) {
        var mymodel=menuArraylist[position]
        holder.menures1.setImageResource(mymodel.menu_img1)
        holder.menures2.setImageResource(mymodel.menu_img2)
        holder.menures3.setImageResource(mymodel.menu_img3)
        holder.menures4.setImageResource(mymodel.menu_img4)
        holder.menures5.setImageResource(mymodel.menu_img5)
    }

    override fun getItemCount(): Int {
        return menuArraylist.size
    }

    class Menu_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        var menures1=itemView.findViewById<ImageView>(R.id.iv_res_menu1)
        var menures2=itemView.findViewById<ImageView>(R.id.iv_res_menu2)
        var menures3=itemView.findViewById<ImageView>(R.id.iv_res_menu3)
        var menures4=itemView.findViewById<ImageView>(R.id.iv_res_menu4)
        var menures5=itemView.findViewById<ImageView>(R.id.iv_res_menu5)

    }
}