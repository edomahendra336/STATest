package com.edomahendra336.statest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "teststa.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "karyawan";
    private static final String COLUMN_ID = "IDKaryawan";
    private static final String COLUMN_NAME = "NmKaryawan";

    private static final String COLUMN_IN = "TglMasukKerja";
    private static final String COLUMN_AGE = "Usia";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE" + TABLE_NAME +
                " (" + COLUMN_ID + " VARCHAR(30) PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " VARCHAR(30), " +
                COLUMN_IN + " TEXT, " +
                COLUMN_AGE + " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
            onCreate(sqLiteDatabase);
    }

    void addNew(String name, String masuk, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_IN, masuk);
        cv.put(COLUMN_AGE, age);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1){
            Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor ReadData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = null;
        if(database != null){
            cursor = database.rawQuery(query,null);
        }
        return cursor;
    }
}
