package mohit.dev.zomato_clone.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import mohit.dev.zomato_clone.R


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        var nav_container = findNavController(R.id.fragmentContainerView)
        bottomnav.setupWithNavController(nav_container)

        var n=nav_container
        

    }
}
