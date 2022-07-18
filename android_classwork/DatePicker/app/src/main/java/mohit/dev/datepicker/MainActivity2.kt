package mohit.dev.datepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var mylv=findViewById<ListView>(R.id.list_view)

        var modelList= mutableListOf<model_class>()

        for (i in 0..8){

            modelList.add(model_class("Android $i",R.mipmap.ktimg))
        }

        var  myAdapter=MyAdapter(this,modelList)
        mylv.adapter=myAdapter


    }
}