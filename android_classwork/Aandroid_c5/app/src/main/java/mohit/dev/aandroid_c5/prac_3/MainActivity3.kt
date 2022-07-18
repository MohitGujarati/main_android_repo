package mohit.dev.aandroid_c5.prac_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mohit.dev.aandroid_c5.R
import mohit.dev.aandroid_c5.prac_1.MainActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        var chk_android = findViewById<CheckBox>(R.id.chk_android)
        var chk_kotlin = findViewById<CheckBox>(R.id.kotlin)
        var chk_java = findViewById<CheckBox>(R.id.java)
        var flt_btn = findViewById<FloatingActionButton>(R.id.flt_btn)

        var check_array = arrayListOf<String>()



        flt_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        chk_android.setOnCheckedChangeListener { componentName, b ->
            if (b) {
                check_array.add(chk_android.text.toString())
                Toast.makeText(this, chk_android.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("array_data", check_array.add(chk_android.text.toString()).toString())


            } else
                check_array.remove(chk_android.text.toString())
            Log.d("array_data", check_array.remove(chk_android.text.toString()).toString())

        }

        chk_kotlin.setOnCheckedChangeListener { componentName, b ->
            if (b) {
                Toast.makeText(this, chk_kotlin.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("array_data", check_array.add(chk_kotlin.text.toString()).toString())
            } else
                Log.d("array_data", check_array.remove(chk_kotlin.text.toString()).toString())
        }

        chk_java.setOnCheckedChangeListener { componentName, b ->
            if (b) {

                Toast.makeText(this, chk_java.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("array_data", check_array.add(chk_java.text.toString()).toString())

            } else

            Log.d("array_data", check_array.remove(chk_android.text.toString()).toString())
        }
    }



}