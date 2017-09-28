package com.example.andylee.myapplication_bus_metro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andylee on 2017/5/30.
 */

public class DBHelper extends SQLiteOpenHelper {
    private final static int _DBVersion = 1;
    private final static String _DBName = "List_info.db";
    private final static String _TableName = "List_metro";
    private final static String _id = "_id";
    private final static String _idnumber = "_idnumber";
    private final static String _station_status = "_station_status";
    private final static String _destination = "_destination";

    public DBHelper(Context context) {
        super(context, _DBName, null, _DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = " CREATE TABLE IF NOT EXISTS " + _TableName + "(" + _id + " INTEGER PRIMARY KEY, " + _idnumber + " INT, " + _station_status+ " CHAR(20), " + _destination + " CHAR(20) " + ");";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + _TableName);
        onCreate(db);
    }

    public void addsomething(data dt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_idnumber, dt.get_idnumber());
        values.put(_station_status, dt.get_station_status());
        values.put(_destination, dt.get_destination());
        db.insert(_TableName, null, values);
        //db.close();
    }
    public List<data> getAlldatas(){
        List<data> dataList = new ArrayList<data>();
        String selectQuery = " SELECT * FROM " + _TableName;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data dt = new data();
                dt.put_idnumber(cursor.getInt(1));
                dt.put_station_status(cursor.getString(2));
                dt.put_destination(cursor.getString(3));
                dataList.add(dt);
            } while (cursor.moveToNext());
        }
        return dataList;
    }
    public void removeAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(_TableName, null, null);
    }
    public void select(int number){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = null;
        if (number == 1){
            sql = "SELECT * FROM " + _TableName + " WHERE " +_destination + "='南港展覽館站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " +_destination + "='動物園站'";
            printf(db, sql);
        }else if (number == 2){
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='淡水站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='象山站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='北投站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='大安站'";
            printf(db, sql);
        }else if (number == 3){
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='松山站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='新店站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='台電大樓站'";
            printf(db, sql);
        }else if (number == 4){
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='蘆洲站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='迴龍站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='南勢角站'";
            printf(db, sql);
        }else if (number == 5){
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='南港展覽館站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='頂埔站'";
            printf(db, sql);
            sql = "SELECT * FROM " + _TableName + " WHERE " + _destination + "='亞東醫院站'";
            printf(db, sql);
        }
        //Cursor cursor = db.rawQuery(sql, new String[]{"淡水站"});

    }
    public void printf(SQLiteDatabase db, String sql){
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int num = cursor.getInt(1);
            String station = cursor.getString(2);
            String destination = cursor.getString(3);
            Log.d("results select", num + " , " + station + " , " + destination);
            Log.d("===========", "<<<>>>");
        }
    }
}
