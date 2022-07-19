package mohit.dev.calculater_app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num1 = findViewById<EditText>(R.id.num1)
        var num2 = findViewById<EditText>(R.id.num2)
        var radio_grp = findViewById<RadioGroup>(R.id.radio_grp)
        var btn_ans = findViewById<Button>(R.id.answer)
        var btn_ac = findViewById<Button>(R.id.ac)
        var show_ans = findViewById<TextView>(R.id.answer_txt)

        var btn_history = findViewById<Button>(R.id.btn_history)
        var txt_history = findViewById<TextView>(R.id.txt_history)

        var radio_choice: Int = 0


        var array_storage = arrayListOf<Int>()

        btn_history.setOnClickListener {
            txt_history.visibility = View.VISIBLE
            var text_ = array_storage.toString()
            txt_history.text = text_

        }



        btn_ac.setOnClickListener {
            num1.text = null
            num2.text = null
            show_ans.text = ""
            array_storage.clear()
            txt_history.text = ""
            txt_history.visibility = View.GONE

        }



        //user clicks on radio btn and it generates a choice
        radio_grp.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.btn_adnroid -> {
                    radio_choice = 1

                }
                R.id.btn_kotlin -> {
                    radio_choice = 2

                }
                R.id.btn_java -> {
                    radio_choice = 3
                }
                R.id.btn_div -> {
                    radio_choice = 4
                }
            }


        }

        //accordinding to choice we calculate the answer

        btn_ans.setOnClickListener {


            var numtxt_1 = Integer.parseInt(num1.text.toString())
            var numtxt_2 = Integer.parseInt(num2.text.toString())


            var choice = radio_choice

            calculate(show_ans, choice, numtxt_1, numtxt_2, array_storage)
        }
    }

    private fun calculate(
        show_ans: TextView,
        choice: Int,
        numtxt1: Int,
        numtxt2: Int,
        array_storage: ArrayList<Int>
    ) {

        when (choice) {
            1 -> {
                var result = numtxt1 + numtxt2
                show_ans.text = result.toString()
                array_storage.add(Integer.parseInt(result.toString()))
                update_array(array_storage)

            }
            2 -> {
                var result = numtxt1 - numtxt2
                show_ans.text = result.toString()
                array_storage.add(Integer.parseInt(result.toString()))
                update_array(array_storage)
            }
            3 -> {
                var result = numtxt1 * numtxt2
                show_ans.text = result.toString()
                array_storage.add(Integer.parseInt(result.toString()))
                update_array(array_storage)
            }
            4 -> {
                var result = numtxt1 / numtxt2
                show_ans.text = result.toString()
                array_storage.add(Integer.parseInt(result.toString()))
                update_array(array_storage)
            }
        }


    }

    private fun update_array(checkArray: ArrayList<Int>) {
        Log.d("array_data", checkArray.toString())
    }
}
