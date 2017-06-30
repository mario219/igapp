package com.mario219.restconsumer.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class DataProspects extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "prospects.db";
    private static final String PROSPECT_TABLE = "PROSPECT";
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String SURNAME = "SURNAME";
    private static final String IDENTIFICATION = "IDENTIFICATION";
    private static final String TELEPHONE = "TELEPHONE";

    private static final String TAG = DataProspects.class.getSimpleName();
    private static DataProspects mInstance = null;
    private Context context;

    public static DataProspects getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new DataProspects(context.getApplicationContext());
        }
        return mInstance;
    }

    private DataProspects(Context context) {
        super(context, DATABASE_NAME , null, 1);
        this.context = context;
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PROSPECT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "SURNAME TEXT, " +
                "IDENTIFICATION LONG, " +
                "TELEPHONE LONG)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PROSPECT_TABLE);
        onCreate(db);
    }

    public void saveProspect(String name, String surname, Long id, Long telephone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(SURNAME, surname);
        contentValues.put(IDENTIFICATION, id);
        contentValues.put(TELEPHONE, telephone);
        long result = db.insert(PROSPECT_TABLE, null, contentValues);
        if(result == -1){
            Log.i(TAG, "something went wrong saving the feed in table.");
        }else{
            Log.i(TAG, "saved");
        }

        db.close();
    }

    public Cursor getAllProspects(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PROSPECT_TABLE, null);
        return cursor;
    }

    public void deleteDataBase(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PROSPECT_TABLE, null, null);
        db.close();
    }

    public void updateProspect(int id, String name, String surname, Long identification, Long tel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(SURNAME, surname);
        cv.put(IDENTIFICATION, identification);
        cv.put(TELEPHONE, tel);
        long result = db.update(PROSPECT_TABLE, cv, ID+"="+id, null);
        if(result == -1){
            Log.i(TAG, "something went wrong saving the feed in table.");
        }else{
            Log.i(TAG, "saved");
        }
    }

}
