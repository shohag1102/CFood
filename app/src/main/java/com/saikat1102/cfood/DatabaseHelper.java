package com.saikat1102.cfood;

import static android.app.SearchManager.QUERY;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "UserFoodDetail.db";
    private static String TABLE_NAME = "UserFoodDetail";
    private static int VERSION = 1;



    public static String COL_FOOD_NAME = "Food_name";
    public static String COL_PRICE = "Price";
    public static String COL_QUANTITY = "Quantity";


    private String CREATE_FOOD_TABLE = "CREATE TABLE UserFoodDetail (\n" +
            "  Order_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "  Food_name TEXT,\n" +
            "  Price INTEGER,\n" +
            "  Quantity INTEGER,\n" +
            "  Product_id TEXT\n" +
            ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_FOOD_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert_data(String foodName, int price, int quantity, String productid){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Food_name", foodName);
        contentValues.put("Price", price);
        contentValues.put("Quantity", quantity);
        contentValues.put("Product_id", productid);

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert("UserFoodDetail", null, contentValues);
        sqLiteDatabase.close();
        return id;
    }

    public static String total_cost = "total_cost";
    public Cursor total_price(){
        String TOTAL_PRICE = "SELECT SUM(Price*Quantity) as total_cost FROM UserFoodDetail";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(TOTAL_PRICE, null);

        return  cursor;
    }


    public Cursor show_data()
    {
        String QUERY = "select * from " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);

        return cursor;
    }

    public void empty_cart(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_NAME);
        sqLiteDatabase.close();
    }


    public static int COL_ID;
    public static String COL_NAME;
    public static String COL_AGE;

    public Cursor search_data(int id){
        String QUERY_SEARCH = "select * from " + TABLE_NAME + " where "+COL_ID +" = "+ id;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY_SEARCH, null);
        return cursor;
    }

    public boolean update_data(int id, String name, String age){
        ContentValues contentValues = new ContentValues();
        contentValues.put(String.valueOf(COL_ID), id);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_AGE, age);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, contentValues, COL_ID + " = ? " ,new String[]{String.valueOf(id)});

        return true;
    }

    public int delete_data(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int check = sqLiteDatabase.delete(TABLE_NAME, COL_ID+"  = ?", new String[]{String.valueOf(id)});
        return check;
    }
}
