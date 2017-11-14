package com.example.carolinereid.taste_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "recipes.db";
    public static final String RECIPES_TABLE_NAME = "recipes";
    public static final String RECIPES_COLUMN_ID = "id";
    public static final String RECIPES_COLUMN_NAME = "name";
    public static final String RECIPES_COLUMN_URL = "url";
    public static final String RECIPES_COLUMN_NOTES = "notes";
    public static final String RECIPES_COLUMN_TRIEDSTATUS = "triedStatus";

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, 6); }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + RECIPES_TABLE_NAME + "(id INTEGER primary key autoincrement, name TEXT, url TEXT, notes TEXT, triedStatus BOOLEAN)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + RECIPES_TABLE_NAME);
        onCreate(db);
    }

    public boolean save(String name, String url, String notes, Boolean triedStatus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RECIPES_COLUMN_NAME, name);
        contentValues.put(RECIPES_COLUMN_URL, url);
        contentValues.put(RECIPES_COLUMN_NOTES, notes);
        contentValues.put(RECIPES_COLUMN_TRIEDSTATUS, triedStatus);
        db.insert(RECIPES_TABLE_NAME, null, contentValues);
        return true;
    }

    public ArrayList<Recipe> all(){
        ArrayList<Recipe> recipes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + RECIPES_TABLE_NAME, null);
        while(cursor.moveToNext()){
            Integer id = cursor.getInt(cursor.getColumnIndex(RECIPES_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(RECIPES_COLUMN_NAME));
            String url = cursor.getString(cursor.getColumnIndex(RECIPES_COLUMN_URL));
            String notes = cursor.getString(cursor.getColumnIndex(RECIPES_COLUMN_NOTES));
            Boolean triedStatus = cursor.getInt(cursor.getColumnIndex(RECIPES_COLUMN_TRIEDSTATUS)) > 0;
            Recipe recipe = new Recipe(id, name, url, notes, triedStatus);
            recipes.add(recipe);
        }
        cursor.close();
        return recipes;
    }

    public void update(Integer id, String name, String url, String notes, Boolean triedStatus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RECIPES_COLUMN_ID, id);
        contentValues.put(RECIPES_COLUMN_NAME, name);
        contentValues.put(RECIPES_COLUMN_URL, url);
        contentValues.put(RECIPES_COLUMN_NOTES, notes);
        contentValues.put(RECIPES_COLUMN_TRIEDSTATUS, triedStatus);
        String selection = " id = ?";
        String values[] = {id.toString()};
        db.update(RECIPES_TABLE_NAME, contentValues, selection, values);
    }

    public void delete(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = " id = ?";
        String[] values = {id.toString()};
        db.delete(RECIPES_TABLE_NAME, selection, values);
    }
}
