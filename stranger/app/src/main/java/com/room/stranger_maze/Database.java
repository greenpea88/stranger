package com.room.stranger_maze;

import android.provider.BaseColumns;

public final class Database {

    public static final class CreateDB implements BaseColumns{
        public static final String ROOMID = "roomid";
        public static final String HINT = "hint";
        public static final String ANSWER = "answer";
        public static final String _TABLENAME0 = "roomtable";
        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                + _ID + " integer primary key autoincrement, "
                + ROOMID + " text not null , "
                + HINT + " text not null , "
                + ANSWER + " text not null);";
    }
}
