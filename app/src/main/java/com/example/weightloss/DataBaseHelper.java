package com.example.weightloss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

class DataBaseHelper extends SQLiteOpenHelper {


    public static final String WEIGHTLOSS_TABLE = "WEIGHTLOSS_TABLE";
    public static final String COLUMN_WEIGHT = "WEIGHT";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "weightLoss.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + WEIGHTLOSS_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEIGHT + " REAL, "
                + COLUMN_DATE + " INTEGER)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  boolean addOne(WeightLossModel weightLossModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        cv.put(COLUMN_WEIGHT, weightLossModel.getWeight());
        cv.put(COLUMN_DATE, weightLossModel.getDate());

        long insert = db.insert(WEIGHTLOSS_TABLE, null, cv);

        if(insert == -1){
            return  false;
        }
        else{
            return  true;
        }
    }

    public List<WeightLossModel> getAll(){
        ArrayList<WeightLossModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + WEIGHTLOSS_TABLE  + " ORDER BY " + COLUMN_DATE + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            //loop through the results and create new Weight Loss Objects
           do{
               int id = cursor.getInt(0);
               float weight = cursor.getFloat(1);
               long date = cursor.getLong(2);

               WeightLossModel newWeightLoss = new WeightLossModel(id, weight, date);
               returnList.add(newWeightLoss);
           }
           while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return returnList;
    }


}
