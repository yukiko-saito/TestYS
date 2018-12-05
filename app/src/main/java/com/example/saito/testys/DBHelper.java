package com.example.saito.testys;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by saito on 2018/11/28.
 */

public class DBHelper extends SQLiteOpenHelper{

    private final static String DB_NAME = "testDB.db";
    private final static String DB_TABLE = "testDB";
    private final static int DB_VERSION = 1;

    // データーベースのバージョン
    private static final int DATABASE_VERSION = 1;

    private static final String _ID = "_id";
    private static final String COLUMN_NAME_TITLE = "company";
    private static final String COLUMN_NAME_SUBTITLE = "stockprice";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DB_TABLE + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE + " TEXT," +
                    COLUMN_NAME_SUBTITLE + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DB_TABLE;

     public DBHelper(Context context){ super(context, DB_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db){
         db.execSQL(SQL_CREATE_ENTRIES);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
