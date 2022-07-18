package mohit.dev.aandroid_c5.prac_2

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import mohit.dev.aandroid_c5.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var intent=getIntent().extras
        Log.d("mydata","email-"+intent!!.getString("keyemail"))




        var btn_4 = findViewById<Button>(R.id.btn_4)
        var toast_container = findViewById<LinearLayout>(R.id.toast_container)
        val layout=layoutInflater.inflate(R.layout.layout_toast,toast_container)




        btn_4.setOnClickListener {
            var tost=Toast(applicationContext)
            tost.duration=Toast.LENGTH_LONG
            tost.setGravity(Gravity.CENTER_VERTICAL,0,0)
            tost.view=layout
            tost.show()

        }

        var layout2=findViewById<LinearLayout>(R.id.ll1)
        var text=TextView(this)
        text.layoutParams=LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        text.text="hello  world"
        text.setTextSize(20f)
        text.setTextColor(Color.BLUE)
        layout2.addView(text)

    }
}