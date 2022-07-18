package mohit.dev.zomato_clone.View

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.zomato_clone.Adapter.MyResmenu_Adapter
import mohit.dev.zomato_clone.Menu_ModelClass
import mohit.dev.zomato_clone.R

class Detail_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var tv_hotelname = findViewById<TextView>(R.id.tv_name)
        var tv_hotelprice = findViewById<TextView>(R.id.tv_price)
        var tv_hotellocation = findViewById<TextView>(R.id.tv_location)
        var tv_hotelratting = findViewById<TextView>(R.id.tv_ratting)
        var iv_hotelImg = findViewById<ImageView>(R.id.iv_hotelimg)
        var iv_hotelLoc = findViewById<TextView>(R.id.detail_Hlocation)
        var toolbarid = findViewById<Toolbar>(R.id.toolbar)
        var ic_camera = findViewById<ImageView>(R.id.Appbar_ic_camera)
        var ic_back = findViewById<ImageView>(R.id.Appbar_ic_back)
        var ic_heart = findViewById<ImageView>(R.id.Appbar_ic_heart)
        var ic_share = findViewById<ImageView>(R.id.Appbar_ic_share)
        var rec_menu = findViewById<RecyclerView>(R.id.rec_menu)


        load_menu(rec_menu)


        var hotelname = getIntent().getStringExtra("name")
        var hotelprice = getIntent().getStringExtra("price")
        var hotelloc = getIntent().getStringExtra("location")
        var hotelratting = getIntent().getStringExtra("ratting")
        var hoteldet_loc = getIntent().getStringExtra("detail_loc")
        var hotelImg = getIntent().getIntExtra("Img", R.drawable.pizzaimg)

        iv_hotelImg.setImageResource(hotelImg)
        tv_hotelname.text = hotelname
        tv_hotelprice.text = hotelprice + "for two"
        tv_hotellocation.text = hotelloc
        tv_hotelratting.text = hotelratting
        iv_hotelLoc.text = hoteldet_loc


        setSupportActionBar(toolbarid)
        // using toolbar as ActionBar

        setSupportActionBar(toolbarid)
        // Display application icon in the toolbar
        toolbarid.title = ""
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        // supportActionBar!!.setLogo(R.drawable.ic_back)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        ic_camera.setOnClickListener {
            Toast.makeText(this, "Camera", Toast.LENGTH_SHORT).show()
        }

        ic_share.setOnClickListener {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()

        }

        ic_heart.setOnClickListener {
            Toast.makeText(this, "heart", Toast.LENGTH_SHORT).show()
        }
        ic_back.setOnClickListener {
            Toast.makeText(this, "back", Toast.LENGTH_SHORT).show()
        }

    }

    private fun load_menu(recMenu: RecyclerView) {
        recMenu.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )

        val menu_arraylist = ArrayList<Menu_ModelClass>()

        menu_arraylist.add(
            Menu_ModelClass(
                R.mipmap.menu,
                R.mipmap.menu,
                R.mipmap.menu,
                R.mipmap.menu,
                R.mipmap.menu,

                )
        )
        //view.context
        var connect_Adapter = MyResmenu_Adapter(this, menu_arraylist)
        recMenu.adapter = connect_Adapter


    }
}