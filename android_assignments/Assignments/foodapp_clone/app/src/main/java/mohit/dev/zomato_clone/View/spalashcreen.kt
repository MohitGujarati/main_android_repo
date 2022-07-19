package mohit.dev.zomato_clone.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import mohit.dev.zomato_clone.R

class spalashcreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalashcreen)

        Handler(Looper.getMainLooper()).postDelayed({
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}