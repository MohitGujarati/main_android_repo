package mohit.dev.june17_recview.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import mohit.dev.june17_recview.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            Handler(Looper.getMainLooper()).postDelayed({
                var i = Intent(this, MainActivity2::class.java)
                startActivity(i)
                finish()

            },3000)
    }
}