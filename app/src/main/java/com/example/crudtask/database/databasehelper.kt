package com.example.crudtask.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class databasehelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyTaskDatabase.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS MyTaskTable (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nameTask TEXT,
                descriptionTask TEXT
            );
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS MyTaskTable")
        onCreate(db)
    }

    /*
    fun insertData(nameTask: String, descriptionTask: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, nameTask)
            put(COLUMN_AGE, descriptionTask)
        }
        val newRowId = db.insert(MyTaskTable, null, values)
        db.close()
        return newRowId
    }

    fun readAllData(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun updateData(id: Int, name: String, age: Int): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_AGE, age)
        }
        val rowsUpdated = db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
        return rowsUpdated
    }

    fun deleteData(id: Int): Int {
        val db = writableDatabase
        val rowsDeleted = db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
        return rowsDeleted
    }
     */
}