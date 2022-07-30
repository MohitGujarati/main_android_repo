package mohit.dev.roomdbtops

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import mohit.dev.roomdbtops.utils.subscribeOnBackground

class NoteRepository(application: Application)
{
    private lateinit var noteDao : NoteDao
    private lateinit var allNotes : LiveData<List<Note>>

    private  val database = NoteDatabase.getInstance(application)

    init {
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note)
    {
        subscribeOnBackground {
            noteDao.insert(note)
        }
    }
    fun update(note: Note)
    {
        subscribeOnBackground {
            noteDao.update(note)
        }
    }
    fun deleteAllNotes(note:Note)
    {
        subscribeOnBackground {
            noteDao.deleteAllNotes()
        }
    }
    fun getAllNotes():LiveData<List<Note>>{
        return allNotes
    }
}