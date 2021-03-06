package com.example.vijay.train;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vijay on 20-02-2017.
 */

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAMEEE="Studenttt.db";
    public static final String TABLE_NAMEEE="studenttt_table";
    public  static final String COL_1="ID";
    public  static final String COL_2="NAME";
    public  static final String COL_3="FEED";
    public  static final String COL_4="MARKS";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAMEEE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ TABLE_NAMEEE +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,FEED TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAMEEE);
        onCreate(sqLiteDatabase);
    }
    public  boolean insertData2(String name, String feed, String marks){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,feed);
        contentValues.put(COL_4,marks);
        long result = sqLiteDatabase.insert(TABLE_NAMEEE,null,contentValues);
        if(result== -1)
            return false;
        else
            return  true;

    }


    public Cursor getAllData2(){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_NAMEEE;
        Cursor res2=sqLiteDatabase.rawQuery(query, null);
        return res2;
    }
}
