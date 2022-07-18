package mohit.dev.aandroid_c5.prac_4

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import mohit.dev.aandroid_c5.R


class MainActivity_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var lv = findViewById<ListView>(R.id.list)
        var edname = findViewById<EditText>(R.id.ed_sname)
        var btnadd = findViewById<Button>(R.id.btn_submit)
        var btnalert = findViewById<Button>(R.id.btn_alert)
        var idspinner = findViewById<Spinner>(R.id.id_spinner)

//Manual adapter
/*


        lv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, ""+lv.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }
        var sub= arrayOf("java","python","Android")
        var adapter:ArrayAdapter<*>
        adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,sub)
        lv.adapter=adapter
 */

        //dynamic adapter

        var st_name = arrayListOf<String>()
        var adapter: ArrayAdapter<*>
        btnadd.setOnClickListener {

            st_name.add(edname.text.toString())
            edname.text.clear()
            adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, st_name)
            lv.adapter = adapter


        }
        lv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "" + lv.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }


        idspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {


                Toast.makeText(
                    applicationContext,
                    "" + idspinner.getItemAtPosition(position),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        btnalert.setOnClickListener {
            var builder = AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Are you sure you want to exit")
                .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
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
}
