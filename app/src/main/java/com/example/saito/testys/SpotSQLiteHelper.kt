package com.example.saito.testys

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.coroutines.coroutineContext

class SpotSQLiteHelper(context: Context) : SQLiteOpenHelper(context, context.getString(R.string.spot_db_name), null, 1) {
    private var SQL_CREATE_ENTRIES = context.getString(R.string.SQL_CREATE_SPOT_TABLE_ENTRIES)
    private var SQL_DELETE_ENTRIES = context.getString(R.string.SQL_DELETE_SPOT_TABLE_ENTRIES)


    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}
