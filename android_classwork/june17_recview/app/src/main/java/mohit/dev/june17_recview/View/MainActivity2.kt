package mohit.dev.june17_recview.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import mohit.dev.june17_recview.Adapter.MyAdapter_class
import mohit.dev.june17_recview.Model.MyModel_class
import mohit.dev.june17_recview.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       // var rec=findViewById<RecyclerView>(R.id.rev)
        var bvn=findViewById<BottomNavigationView>(R.id.bottom_navigation)


      //  recview(rec)

    //    load_frg(Home_Frag())

        /*
       bvn.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.op_home->{
                    load_frg(Home_Frag())
                }
                R.id.op_profile->{
                    load_frg(Profile_frg())
                }


            }


        }


         */


        var navcnt=findNavController(R.id.fragmentContainerView)
        bvn.setupWithNavController(navcnt)



    }

    private fun load_frg(frag:Fragment) {

        var frg_transaction=supportFragmentManager.beginTransaction()
        frg_transaction.replace(R.id.cointainer,frag)
        frg_transaction.addToBackStack(null)
        frg_transaction.commit()
    }

    private fun recview(rec: RecyclerView) {
        //   rec.layoutManager=LinearLayoutManager(this)
        rec.layoutManager=GridLayoutManager(this,2)
        val arrylist=ArrayList<MyModel_class>()

        for (i in 0..15){
            arrylist.add(MyModel_class(R.mipmap.downloadkotlinimg,"Kotlin $i"))
        }

        var myAdapter= MyAdapter_class(arrylist)
        rec.adapter=myAdapter
    }
}