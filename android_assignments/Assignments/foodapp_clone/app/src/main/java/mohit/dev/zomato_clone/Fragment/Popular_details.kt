package mohit.dev.zomato_clone.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Adapter.MyCategory_Adapter
import mohit.dev.zomato_clone.Category_ModelClass
import mohit.dev.zomato_clone.R


class Popular_details : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v= inflater.inflate(R.layout.fragment_popular_details, container, false)

        var frg_category= v.findViewById<RecyclerView>(R.id.frg_category)
        loaddata(frg_category,v)



        return v
    }

    private fun loaddata(frg_category: RecyclerView, v: View) {
        frg_category.layoutManager = GridLayoutManager(context, 4)

        val cat_arrayList = ArrayList<Category_ModelClass>()

        for (i in 1..8) {
            cat_arrayList.add(
                Category_ModelClass(
                    R.drawable.ic_dining,
                    "category $i"
                )
            )
        }
        var MyCategory_Adapter = MyCategory_Adapter(v.context,cat_arrayList)
        frg_category.adapter = MyCategory_Adapter
    }
}