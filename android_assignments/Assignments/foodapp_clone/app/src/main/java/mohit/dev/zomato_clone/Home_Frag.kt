package mohit.dev.zomato_clone

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Adapter.MyCategory_Adapter
import mohit.dev.zomato_clone.Adapter.MyCombo_Adapter


class Home_Frag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home_, container, false)

        var combo_recview = v.findViewById<RecyclerView>(R.id.combo_list)
        var category_recview = v.findViewById<RecyclerView>(R.id.category_list)
        var location_spinner = v.findViewById<Spinner>(R.id.location_spinner)
        var category_tv = v.findViewById<TextView>(R.id.category_tv)
        var card_category = v.findViewById<CardView>(R.id.card_category)


        //  spinner_dataInsert(location_spinner,category_tv,v)

        //  addlocation(location_spinner, category_tv, v)

        load_combo_list(combo_recview, v)

        load_category_list(category_recview, v)




        return v
    }

    //spinner for location
    /*private fun spinner_dataInsert(location_spinner: Spinner, category_tv: TextView, v: View) {
        location_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                var st_name = arrayListOf<String>()
                var adapter: ArrayAdapter<*>
                st_name.add(category_tv.text.toString())

                val spin = v.findViewById<View>(R.id.location_spinner) as Spinner
                spin.onItemSelectedListener = this
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, st_name)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                spin.adapter = adapter

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }

     */

    //Dialog for Location
    private fun addlocation(location_spinner: Spinner, category_tv: TextView, v: View) {

        var d = Dialog(v.context)
        d.setContentView(R.layout.custom_locationinput)
        d.setCancelable(true)
        d.show()

        var ed_name = d.findViewById<EditText>(R.id.cname)
        var c_btn = d.findViewById<Button>(R.id.cus_btn)

        c_btn.setOnClickListener {
            //  category_tv.text = ed_name.text.toString()
            d.dismiss()
        }

    }

    //method for category
    private fun load_category_list(category_recview: RecyclerView, v: View) {
        //  Toast.makeText(this, "hello ", Toast.LENGTH_SHORT).show()
        category_recview.layoutManager = GridLayoutManager(v.context, 4)

        val cat_arrayList = ArrayList<Category_ModelClass>()

        for (i in 1..8) {
            cat_arrayList.add(
                Category_ModelClass(
                    R.drawable.burger,
                    "category $i"
                )
            )
        }

        var MyCategory_Adapter = MyCategory_Adapter(v.context,cat_arrayList)
        category_recview.adapter = MyCategory_Adapter

    }

    //method for products
    private fun load_combo_list(combo_recview: RecyclerView, v: View) {

        combo_recview.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
        val combo_arraylist = ArrayList<Combo_ModelClass>()


        for (i in 1..5) {

            combo_arraylist.add(
                Combo_ModelClass(
                    R.mipmap.combo_burger
                )
            )
            combo_arraylist.add(
                Combo_ModelClass(
                    R.mipmap.combo_pizza
                )
            )
            combo_arraylist.add(
                Combo_ModelClass(
                    R.mipmap.combo_pasta
                )
            )
            var myAdapter = MyCombo_Adapter(combo_arraylist)
            combo_recview.adapter = myAdapter
        }
    }
}

//product list
/*
 combo_arraylist.add(
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
 */
