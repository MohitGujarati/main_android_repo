package mohit.dev.aandroid_c5.prac_5

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import mohit.dev.aandroid_c5.R
import java.util.*

class MainActivity_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var btn_pickdate = findViewById<Button>(R.id.btn_pickdater_1)
        var btn_2=findViewById<Button>(R.id.btn_pickdater_2)


        //POPUP MENU
        /*
        var btn_pm=findViewById<Button>(R.id.btn_pm)

        var popMenu=PopupMenu(applicationContext,btn_pm)

        popMenu.menuInflater.inflate(R.menu.popup,popMenu.menu)

        btn_pm.setOnClickListener {
            popMenu.show()
        }

        popMenu.setOnMenuItemClickListener {
            if (it.itemId==R.id.op_Delete){
                var i= Intent(this,MainActivity3::class.java)
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

         */



        var Todaydate = Calendar.getInstance()
        var year = Todaydate.get(Calendar.YEAR)
        var month = Todaydate.get(Calendar.MONTH)
        var day = Todaydate.get(Calendar.DAY_OF_MONTH)

        btn_pickdate.setOnClickListener {
            var d=19
            var datepickerbox= DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view, year, month, d ->
                var m = month + 1

                btn_pickdate.text = "$day $m $year "

            }, year, month, d)
                .show()

        }



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.op_profile) {
            var i = Intent(this, Sub_act_5::class.java)
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
            startActivity(i)

        } else if (item.itemId == R.id.op_settings) {
            var i = Intent(this, MainActivity_5::class.java)
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            startActivity(i)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        var builder = AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Are you sure you want to exit")
            .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show()
                finish()
                //     dialog.dismiss()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            .setNeutralButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })
            .setCancelable(false)

        builder.show()
    }




}