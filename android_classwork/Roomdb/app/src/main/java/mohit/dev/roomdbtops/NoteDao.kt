package mohit.dev.roomdbtops

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update()

    @Query("delete from note_table")
    fun delete()

    @Query("select * from note_table order by priority desc")
    fun priority(): LiveData<List<Note>>
}