package mohit.dev.frg_1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var tv = findViewById<TextView>(R.id.tv)


        var Bundle = Bundle()
        val txt =intent.extras?.get("mydata")
       //var msg = Bundle?.getString("mydata")
        tv.text = txt.toString()
    }
}