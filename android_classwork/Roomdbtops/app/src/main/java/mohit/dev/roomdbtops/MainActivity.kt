package mohit.dev.roomdbtops

import android.app.Notification
import android.content.Intent
import android.icu.lang.UCharacter.IndicPositionalCategory.LEFT
import android.icu.lang.UCharacter.IndicPositionalCategory.RIGHT
import android.nfc.NfcAdapter
import android.os.Bundle
import android.telecom.TelecomManager.EXTRA_PRIORITY
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mohit.dev.roomdbtops.Adapter.NoteAdapter

const val ADD_NOTE_REQUEST= 1
const val EDIT_NOTE_REQUEST= 2

class MainActivity : AppCompatActivity() {
    private lateinit var vm: NoteViewModel
    private lateinit var adapter: NoteAdapter
    private lateinit var rec_view: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rec_view = findViewById<RecyclerView>(R.id.rec_view)
        var btnadd = findViewById<FloatingActionButton>(R.id.btnadd)

        set_recyclerview(rec_view)

        btnadd.setOnClickListener {

        }

        vm = ViewModelProviders.of(this)[NoteViewModel::class.java]

        vm.getAllNotes().observe(this, {
            adapter.submitList(it)
        })

    }


    fun setupListsteners() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, LEFT or RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var note = adapter.getNoteAt(viewHolder.adapterPosition)
                vm.deleteAllNote(note)
            }


        }).attachToRecyclerView(rec_view)
    }

    fun set_recyclerview(recyclerview: RecyclerView) {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)


        adapter = NoteAdapter { clickedNote ->
            val intent = Intent(this, AddEditActivity::class.java)

            intent.putExtra(NfcAdapter.EXTRA_ID, clickedNote.id)
            intent.putExtra(Notification.EXTRA_TITLE, clickedNote.title)
            intent.putExtra(EXTRA_DESCRIPTION, clickedNote.des)
            intent.putExtra(EXTRA_PRIORITY, clickedNote.priority)
            startActivityForResult(intent,EDIT_NOTE_REQUEST)

        }

        recyclerview.adapter = adapter


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}