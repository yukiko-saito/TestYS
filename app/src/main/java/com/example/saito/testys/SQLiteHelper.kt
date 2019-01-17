package com.example.saito.testys

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {

        private var DB_NAME = "testDB.db"
        private var DB_TABLE = "testDB"
        private var DB_VERSION = 1

        // データーベースのバージョン
        private var DATABASE_VERSION = 1

        private var ID = "_id"
        private var COLUMN_NAME_TITLE = "company"
        private var COLUMN_NAME_SUBTITLE = "stockprice"

        private val SQL_CREATE_ENTRIES = "CREATE TABLE " + DB_TABLE + " (" +
                ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_TITLE + " TEXT," +
                COLUMN_NAME_SUBTITLE + " INTEGER)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $DB_TABLE"
    }

}
