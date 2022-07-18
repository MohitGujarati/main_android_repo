package mohit.dev.aandroid_c5.prac_6

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import mohit.dev.aandroid_c5.R

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        var btn_main = findViewById<Button>(R.id.btn_main)
        var tv_main = findViewById<TextView>(R.id.tv_main)



        btn_main.setOnClickListener {


            var d = Dialog(this)
            d.setContentView(R.layout.cus_layout)
            d.setCancelable(false)
            d.show()

            var ed_name = d.findViewById<EditText>(R.id.cname)
            var c_btn = d.findViewById<Button>(R.id.cus_btn)

            c_btn.setOnClickListener {
                tv_main.setText(ed_name.text.toString())
                d.dismiss()
            }


            /*

            var mydialog = AlertDialog.Builder(this)
            mydialog.setTitle("hello")
            var sub = arrayOf("android", "kotlin", "java")

            /*
            mydialog.setItems(sub,DialogInterface.OnClickListener { dialog, i ->
                when(i){
                    0-> Toast.makeText(this, "android", Toast.LENGTH_SHORT).show()
                    1-> Toast.makeText(this, "kotlin", Toast.LENGTH_SHORT).show()
                    2-> Toast.makeText(this, "java", Toast.LENGTH_SHORT).show()
                }
            })
            var dialog=mydialog.create()
            dialog.show()
        }

           */

            //single choice dialog
            /*


            mydialog.setSingleChoiceItems(sub,3,DialogInterface.OnClickListener { dialog, i ->
                Toast.makeText(this, ""+sub[i], Toast.LENGTH_SHORT).show()
            })

             */

            var myselarray= arrayListOf<String>()

            mydialog.setMultiChoiceItems(sub,null,DialogInterface.OnMultiChoiceClickListener { dialog, i, isChecked ->
                if (isChecked){
                    myselarray.add((sub[i]))
                }
                else
                    myselarray.remove(sub[i])
            })
            var dialog=mydialog.create()
            dialog.show()
        }

             */
        }
    }
}