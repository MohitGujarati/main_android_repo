package mohit.dev.navigation_compo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)

        var navcnt=findNavController(R.id.fragmentContainerView)
       bottomnav.setupWithNavController(navcnt)
    }
}