package mohit.dev.expensemanager.Adpter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import mohit.dev.expensemanager.Database.note_database
import mohit.dev.expensemanager.Model.Notes_ModelClass
import mohit.dev.expensemanager.View.User_Notes
import mohit.dev.sqlite_prg.R

class Mynotes_Adapter(
    var context: Context,
    var Notes_Arraylist: MutableList<Notes_ModelClass>,
    progressArray: ArrayList<Int>
) :
    RecyclerView.Adapter<Mynotes_Adapter.ViewHolder>() {


    var progress_persentage = progressArray
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_notes, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var mymodel = Notes_Arraylist[position]
        holder.tvamount.text = mymodel.user_amount.toString()
        holder.tvcategory.text = mymodel.user_category
        holder.tvdate.text = mymodel.user_date
        holder.tvnote.text = mymodel.user_note

        holder.progress_horizontal.setProgress(progress_persentage[position])

        Log.d("bar_pg", "${progress_persentage}")


        val rnd = java.util.Random()
        val color: Int = Color.argb(200, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.imageview.setBackgroundColor(color)

        holder.iv_btndelete.setOnClickListener {
            var dbhelper = note_database(context)

            Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show()
            var id_delete =
                dbhelper.note_delete(Notes_ModelClass(mymodel.noteid, 0, "", "", "", 0))
            var i = Intent(context, User_Notes::class.java)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return Notes_Arraylist.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        var tvamount = itemView.findViewById<TextView>(R.id.tv_amount)
        var tvcategory = itemView.findViewById<TextView>(R.id.tv_cat)
        var tvdate = itemView.findViewById<TextView>(R.id.tv_date)
        var tvnote = itemView.findViewById<TextView>(R.id.tv_note)
        var iv_btndelete = itemView.findViewById<ImageView>(R.id.iv_btndelete)
        var imageview = itemView.findViewById<ImageView>(R.id.imageview)
        var progress_horizontal = itemView.findViewById<ProgressBar>(R.id.progress_horizontal)


    }

}