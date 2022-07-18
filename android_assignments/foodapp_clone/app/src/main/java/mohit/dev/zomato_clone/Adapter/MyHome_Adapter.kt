package mohit.dev.zomato_clone.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.R
import mohit.dev.zomato_clone.product_ModelClass

class MyHome_Adapter(var arraylist: List<product_ModelClass>) :
    RecyclerView.Adapter<MyHome_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_product_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var mymodel = arraylist[position]

        holder.iv_image.setImageResource(mymodel.img)
        holder.item_title.setText(mymodel.title)
        holder.ed_category.setText(mymodel.sub_cat)
        ("Rs" + holder.ed_cost.setText(mymodel.cost) + "/")
        holder.item_ratting.setText(mymodel.rating)
        holder.item_payment.setText(mymodel.payment_type.toString())
        holder.ed_avg_time.setText((mymodel.time) + "min •")
        holder.item_discount.setText((mymodel.discount_amount.toString()) + "% OFF")


        utils(mymodel, holder, holder.rating_card, mymodel.discount_amount, holder.item_discount, holder.item_payment)


    }

    private fun utils(
        mymodel: product_ModelClass,
        holder: ViewHolder,
        ratingCard: CardView,
        discountAmount: Int,
        itemDiscount: TextView?,
        itemPayment: TextView?,
    ) {

        var rt = holder.item_ratting.text
        var payment = holder.item_payment.text

        when (rt) {
            2.0.toString() -> {
                holder.rating_card.setBackgroundResource(R.drawable.low_rating_bg)
            }
            3.0.toString() -> {

                holder.rating_card.setBackgroundResource(R.drawable.midum_rating_bg)

            }
            else -> {
                holder.rating_card.setBackgroundResource(R.drawable.high_rating_bg)
            }
        }

        when (mymodel.discount_amount) {
            0 -> holder.item_discount.visibility = View.GONE

        }

        when (payment.toString()) {
            "0" -> holder.item_payment.text = "Pay Online/Cash"
            "1" -> holder.item_payment.text = "Pay Online Only"
            "2" -> holder.item_payment.text = "Pay Cash Only"
        }
    }


    override fun getItemCount(): Int {
        return arraylist.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var iv_image = itemView.findViewById<ImageView>(R.id.iv_image)
        var item_title = itemView.findViewById<TextView>(R.id.item_title)
        var ed_category = itemView.findViewById<TextView>(R.id.ed_category)
        var ed_cost = itemView.findViewById<TextView>(R.id.ed_cost)
        var ed_avg_time = itemView.findViewById<TextView>(R.id.ed_avg_time)
        var item_payment = itemView.findViewById<TextView>(R.id.item_payment)
        var item_ratting = itemView.findViewById<TextView>(R.id.item_ratting)
        var item_discount = itemView.findViewById<TextView>(R.id.item_discount)
        var rating_card = itemView.findViewById<CardView>(R.id.rating_card)
        var main_Product_layout=itemView.findViewById<RelativeLayout>(R.id.main_Product_layout)

    }

}