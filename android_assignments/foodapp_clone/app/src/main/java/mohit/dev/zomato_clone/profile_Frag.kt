package mohit.dev.zomato_clone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import mohit.dev.zomato_clone.Database.UserModel

class profile_Frag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_profile, container, false)

        var add = v.findViewById<Button>(R.id.btn_addlocation)
        var mainlayout = v.findViewById<LinearLayout>(R.id.mainlayout)


        var onClick = true

        add.setOnClickListener {
            if (onClick  == true) {
                mainlayout.visibility = View.VISIBLE
                var tv_name = v.findViewById<EditText>(R.id.tv_userAddress)
                var tv_Email = v.findViewById<EditText>(R.id.tv_UserPincode)

                var btnsave = v.findViewById<Button>(R.id.btnsave)

                btnsave.setOnClickListener {

                    var id=dbhelper.insertData(
                        UserModel(
                            v.id,
                            tv_name.text.toString(),
                            tv_Email.text.toString()
                        )
                    )

                    if (id > 0) {
                        Log.d("mydata", "id-" + id)
                        // var intent= Intent(this,ViewUser::class.java)
                        Toast.makeText(context, "saved at $id", Toast.LENGTH_SHORT).show()
                        //  startActivity(intent)
                    } else {
                        Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }

                onClick=false

            } else {
                mainlayout.visibility = View.GONE
                onClick=true

            }


        }
        return v


    }
}