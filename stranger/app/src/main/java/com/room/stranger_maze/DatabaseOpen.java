package com.room.stranger_maze;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpen {

    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    public class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            //생성자
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            //테이블 생성
            db.execSQL(Database.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //버젼 업그레이드 시
            db.execSQL("DROP TABLE IF EXISTS "+Database.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public DatabaseOpen(Context context){
        this.mCtx = context;
    }

    public DatabaseOpen open() throws SQLException{
        //해당 데이터베이스 열어서 사용 가능하도록 함
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        mDBHelper.onCreate(mDB);
    }

    public void close(){
        mDBHelper.close();
    }

    // Insert DB
    public long insertColumn(String roomid, String hint, String answer){
        ContentValues values = new ContentValues();
        values.put(Database.CreateDB.ROOMID, roomid);
        values.put(Database.CreateDB.HINT, hint);
        values.put(Database.CreateDB.ANSWER, answer);
        return mDB.insert(Database.CreateDB._TABLENAME0, null, values);
    }


    // Select DB
    public Cursor selectColumns(){
        return mDB.query(Database.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }
}
