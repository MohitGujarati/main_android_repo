package mohit.dev.androidclass_c4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_next=findViewById<Button>(R.id.btn_next)
        var rg=findViewById<RadioGroup>(R.id.radioGrp)

        var btntxt:String



/*
        btn_next.setOnClickListener {
            var intent=Intent(this,MainActivity2::class.java)

            startActivity(intent)
            finish()
        }



        btn_next.setOnClickListener {
            var intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.tops-int.com/"))
            startActivity(intent)

        }


 */

        btn_next.setOnClickListener {

        rg.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId==R.id.rb_Android){
                Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show()
                btntxt="Android"
                btn_next.text=btntxt.toString()

            }
           else if (checkedId==R.id.rb_kotlin){
                Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show()
                btntxt="kotlin"
                btn_next.text=btntxt.toString()

            }
            else if (checkedId==R.id.rb_java){
                Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show()
                btntxt="java"
                btn_next.text=btntxt.toString()
            }

        }


        }
    }
}