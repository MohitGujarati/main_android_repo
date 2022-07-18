package mohit.dev.frg_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lv=findViewById<LinearLayout>(R.id.container_main)
        var btn=findViewById<Button>(R.id.btnsenddata)
        var eddata =findViewById<EditText>(R.id.eddata)


        //implementation of transaction to fragments
        var fragmentManager=supportFragmentManager
        var fragmentTransaction=fragmentManager.beginTransaction()
        var fragment1=BlankFragment_1()



        //sending data to another Fragment using bundle
        btn.setOnClickListener {
            var bundle=Bundle()
            bundle.putString("mydata",eddata.text.toString())
            fragment1.arguments=bundle
            fragmentTransaction.add(R.id.container_main,fragment1).commit()
        }

       // fragmentTransaction.add(R.id.container_main,fragment1).commit()//save
    }
}