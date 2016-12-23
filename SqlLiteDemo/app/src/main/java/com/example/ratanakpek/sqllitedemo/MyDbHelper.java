package com.example.ratanakpek.sqllitedemo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RatanakPek on 11/17/2016.
 */

public class MyDbHelper  {
    DbHelp helper;
    public MyDbHelper(Context context) {
        helper=new DbHelp(context);
    }

    public long insertData(String username, String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(DbHelp.NAME, username);
        data.put(DbHelp.PASSWORD, password);
        long id=db.insert(DbHelp.TABLE_NAME, null, data);
        return id;
    }

    public String SelectData(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String [] column={DbHelp.UID, DbHelp.NAME, DbHelp.PASSWORD};
        Cursor cur =db.query(DbHelp.TABLE_NAME, column, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while(cur.moveToNext()){
            int id=cur.getInt(0);
            String name = cur.getString(1);
            String pass = cur.getString(2);
            buffer.append(id+"/"+name+"/"+pass+"\n");
        }
    return buffer.toString();

    }

    public String delete(String query){
        SQLiteDatabase d = helper.getWritableDatabase();
        String arg[]={query};
        String data;
        int i= d.delete(DbHelp.TABLE_NAME,DbHelp.NAME+"=?", arg);
            if(i!=0){
                data="Deleted";
            }else{
               data="Can not deleted";
            }

        return data;
    }

    public String update(String name, String pass){

        SQLiteDatabase d = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelp.PASSWORD, pass);
        String ar[]={name};
        int i=d.update(DbHelp.TABLE_NAME, values, DbHelp.NAME+"=?", ar);
        String data;
        if(i!=0){
            data="Done";
        }else{
            data="UnDone";
        }

        return data;
    }

    public String selectByName(String name, String password){
        SQLiteDatabase d = helper.getReadableDatabase();
        String [] colmn = {DbHelp.UID, DbHelp.NAME, DbHelp.PASSWORD};
        String [] arg = {name, password};
        StringBuffer buffer = new StringBuffer();
        Cursor cursor=d.query(DbHelp.TABLE_NAME,colmn, DbHelp.NAME+" =? AND "+DbHelp.PASSWORD+"=?", arg, null, null, null, null);

        while(cursor.moveToNext()){
            int nam = cursor.getColumnIndex(DbHelp.NAME);
            int pas=cursor.getColumnIndex(DbHelp.PASSWORD);
            String user=cursor.getString(nam);
            String passw=cursor.getString(pas);
            buffer.append(user+"/"+passw+"\n");
        }return buffer.toString();
    }



    static class DbHelp extends SQLiteOpenHelper{
       private static final String DATABASE_NAME="user.db";
       private static final String TABLE_NAME="user";
       private static final int DATABASE_VERSION=3;
       private static final String UID="_id";
       private static final String NAME="Name";
       private static final String PASSWORD="Password";


       private static final String CREATE_TABLE=
               "CREATE TABLE "+ TABLE_NAME
                       +" ("+UID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                       +NAME + " VARCHAR(255), "
                       + PASSWORD+" VARCHAR(255));";



       private static final String DROP_TABLE= "DROP TABLE IF EXIST "+TABLE_NAME;
       private static Context context;

       public DbHelp(Context context) {
           super(context, DATABASE_NAME, null, DATABASE_VERSION);
           this.context=context;
       }


       @Override
       public void onCreate(SQLiteDatabase sqLiteDatabase) {
           try {
               sqLiteDatabase.execSQL(CREATE_TABLE);
               Message.message(context, "on Create");
           }catch (Exception e)
           {
               e.printStackTrace();
           }
       }

       @Override
       public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
           try {
               sqLiteDatabase.execSQL(DROP_TABLE);
               Message.message(context, "on Upgrade");
               onCreate(sqLiteDatabase);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
   }
}
