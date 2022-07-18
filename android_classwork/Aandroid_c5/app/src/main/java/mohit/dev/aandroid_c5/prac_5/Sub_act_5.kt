package mohit.dev.aandroid_c5.prac_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import mohit.dev.aandroid_c5.R
import mohit.dev.aandroid_c5.prac_3.MainActivity3

class Sub_act_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_act5)

        var btn_pm=findViewById<Button>(R.id.btn_pm)

        var popMenu= PopupMenu(applicationContext,btn_pm)

        popMenu.menuInflater.inflate(R.menu.popup,popMenu.menu)

        btn_pm.setOnClickListener {
            popMenu.show()
        }

        popMenu.setOnMenuItemClickListener {
            if (it.itemId==R.id.op_Delete){
                var i= Intent(this, MainActivity_5::class.java)
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
                startActivity(i)

            }
            else if (it.itemId==R.id.op_Cancel){
                var i= Intent(this,Sub_act_5::class.java)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                startActivity(i)
            }
            true
        }
    }

}