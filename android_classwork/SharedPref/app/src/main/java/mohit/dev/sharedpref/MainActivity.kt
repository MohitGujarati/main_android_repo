package mohit.dev.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Log_userName = findViewById<EditText>(R.id.tv_userName_Log)
        var Log_userPass = findViewById<EditText>(R.id.tv_UserPass_Log)
        var btn_login=findViewById<Button>(R.id.btn_login)


        val custom_pref="userdata"

        val sharedPreferences:SharedPreferences=this.getSharedPreferences(custom_pref,Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor=sharedPreferences.edit()

        var result=sharedPreferences.getBoolean("key_status",false)

        if (result==true){

            var i=Intent(this,Dash::class.java)
            finish()
            startActivity(i)
        }

        btn_login.setOnClickListener {

            editor.putString("Key_email",Log_userName.text.toString())
            editor.putString("Key_password",Log_userPass.text.toString())
            editor.putBoolean("key_status",true)

            editor.apply()
            editor.commit()


            var i=Intent(this,Dash::class.java)
            finish()
            startActivity(i)




        }
    }
}