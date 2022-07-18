package mohit.dev.zomato_clone.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Databasehelper(var context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "mydb"
        private val DATABASE_VERSION = 1


        private const val TABLE_NAME = "locationdata"
        private const val KEY_ID = "id"
        private const val KEY_USERADDRESS = "useraddress"
        private const val KEY_USERPINCODE = "userpincode"


    }


    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE =
            (
                    "CREATE TABLE " + TABLE_NAME + " "
                            + " ( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                            + KEY_USERADDRESS + " TEXT, " + ""
                            + KEY_USERPINCODE + " TEXT)"
                    )

        db?.execSQL(CREATE_TABLE)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(userModel: UserModel): Long {
        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(KEY_USERADDRESS, userModel.userAddress)
        cv.put(KEY_USERPINCODE, userModel.userPincode)


        var inserData = db.insert(TABLE_NAME, null, cv)
        return inserData

    }

}