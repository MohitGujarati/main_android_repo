package mohit.dev.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Dash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        var tv_email=findViewById<TextView>(R.id.Home_useremail)
        var btn_logout=findViewById<Button>(R.id.btn_logout)

        val custom_pref="userdata"
        val sharedPreferences: SharedPreferences =this.getSharedPreferences(custom_pref, Context.MODE_PRIVATE)

        var shared_value=sharedPreferences.getString("Key_email","default")
        tv_email.text=shared_value


        btn_logout.setOnClickListener {
            var editor=sharedPreferences.edit()

            editor.clear()
            editor.commit()

            var i=Intent(this,MainActivity::class.java)
            finish()
            startActivity(i)
        }

    }
}