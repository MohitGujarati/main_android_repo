package mohit.dev.hotel_nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var toolbar=findViewById<Toolbar>(R.id.tootlbar)

        setSupportActionBar(toolbar)
        var drlayout=findViewById<DrawerLayout>(R.id.dr)

        var nav_view=findViewById<NavigationView>(R.id.nav_view)

        var nav_coinatiner=findNavController(R.id.navhostfrag)

        appBarConfiguration= AppBarConfiguration(setOf(R.id.navigate_home,R.id.navigate_hotel),drlayout)
        setupActionBarWithNavController(nav_coinatiner,appBarConfiguration)
        nav_view.setupWithNavController(nav_coinatiner)

    }

    override fun onSupportNavigateUp(): Boolean {
        var  nav_cont=findNavController(R.id.navhostfrag)
        return nav_cont.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
}