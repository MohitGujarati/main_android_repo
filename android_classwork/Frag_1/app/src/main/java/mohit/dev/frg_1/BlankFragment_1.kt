package mohit.dev.frg_1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class BlankFragment_1 : Fragment() {

 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

     var v=inflater.inflate(R.layout.fragment_blank_1, container, false)

     var btn=v.findViewById<Button>(R.id.btn_activity)
     var tv=v.findViewById<TextView>(R.id.showdata)


     //receiving data in this fragment
     //and setting it in textview
     var bundle=arguments
     var message=bundle?.getString("mydata")
     tv.text = message




     //sending the data to another activity
     var fragment1=BlankFragment_1()
     btn.setOnClickListener {

         var bundle=Bundle()
         //passing data to activity 2
         var i=Intent(activity,MainActivity2::class.java)
         i.putExtra("mydata",tv.text.toString())
//         bundle.putString("mydata",tv.text.toString())
//         fragment1.arguments=bundle
         startActivity(i)
     }
        return v
    }


}