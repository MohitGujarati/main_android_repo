package mohit.dev.datepicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn_birth = findViewById<Button>(R.id.btn_bithdate)
        var btn_Maxdate = findViewById<Button>(R.id.btn_Maxdate)
        var btn_mindate = findViewById<Button>(R.id.btn_mindate)


        var tvdate=findViewById<TextView>(R.id.setdata)
        var edday=findViewById<EditText>(R.id.userday)
        var edmonth=findViewById<EditText>(R.id.usermonth)
        var edyear=findViewById<EditText>(R.id.useryear)
      //  var datepicker=findViewById<DatePicker>(R.id.date_picker_actions)


        btn_birth.setOnClickListener {

            var todaytime=Calendar.getInstance()
            var useryear=Integer.parseInt(edyear.text.toString())
            var usermonth=Integer.parseInt(edmonth.text.toString())
            var userday=Integer.parseInt(edday.text.toString())
            val sDate1 = "$userday/$usermonth/$useryear"
            val date1: Date = SimpleDateFormat("dd/MM/yyyy").parse(sDate1)



            var datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                var m = month + 1
                tvdate.text="$userday $usermonth $useryear"
            }, useryear, usermonth-1, userday)
            datePickerDialog.datePicker.maxDate=todaytime.timeInMillis
          //  datePickerDialog.datePicker.minDate=userday
            datePickerDialog.show()
        }

        btn_Maxdate.setOnClickListener {

            var Todaydate = Calendar.getInstance()
            var year = Todaydate.get(Calendar.YEAR)
            var month = Todaydate.get(Calendar.MONTH)
            var day = Todaydate.get(Calendar.DAY_OF_MONTH)



            var datepickerbox= DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view, year, month, d ->
                var m = month + 1
            }, year, month, day)
            datepickerbox.datePicker.minDate=Todaydate.timeInMillis
            datepickerbox.show()

        }

        btn_mindate.setOnClickListener {

            var Todaydate = Calendar.getInstance()
            var year = Todaydate.get(Calendar.YEAR)
            var month = Todaydate.get(Calendar.MONTH)
            var day = Todaydate.get(Calendar.DAY_OF_MONTH)



            var datepickerbox= DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view, year, month, d ->
                var m = month + 1
            }, year, month, day)
            datepickerbox.datePicker.maxDate=Todaydate.timeInMillis
            datepickerbox.show()

        }


    }
}