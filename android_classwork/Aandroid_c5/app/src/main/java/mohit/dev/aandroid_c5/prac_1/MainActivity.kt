package mohit.dev.aandroid_c5.prac_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import mohit.dev.aandroid_c5.prac_2.MainActivity2
import mohit.dev.aandroid_c5.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed_email = findViewById<EditText>(R.id.ed_email)
        var btn_next = findViewById<Button>(R.id.btn_next)

/*
        var ed_rev=findViewById<EditText>(R.id.edrev_num)
        var show_rev=findViewById<TextView>(R.id.tvshow_rev)

        ed_rev.setOnClickListener {
            var to_rev= Integer.parseInt(ed_rev.text.toString())
          //  fun_rev(to_rev,show_rev)
        }
    }

    private fun fun_rev(num: Int, showRev: TextView) {

        var rev_num=0
        var num2=num
        while (num2 > 0) {
            rev_num = rev_num * 10 + num2 % 10;
            num2 = num2 / 10;
        }
        showRev.text=rev_num.toString()
    }

 */


        btn_next.setOnClickListener {

            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("keyemail", ed_email.text.toString())
            startActivity(intent)
        }


    }
}