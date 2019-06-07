package com.example.newapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.RadioButton;

public class Dbhelper extends SQLiteOpenHelper {
        public Dbhelper(Context context)
        {
            super(context,"Registerdb",null,1);


        }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Registerdb(id interger primary key AUTOINCREMENT,name text , FatherName text , phone text, email text UNIQUE, password text,gender text )");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = ("DROP TABLE IF EXTSTS Registerdb");

    }


    public boolean insertion(String name , String f_name, String phone, String email, String password, String gender, int count)


    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("Name",name);
        values.put("FatherName", f_name);
        values.put("Phone",phone);
        values.put("Email",email);
        values.put("Password",password);
        values.put("Gender",gender);


       long isInserted;
       if (count ==1)
           isInserted=db.insert("Registerdb",null,values);
       else
       {
           String[] where = {email};
           isInserted=  db.update("Registerdb",values,"email = ?",where);

       }
       if (isInserted==-1)
           return false;
       else
           return true;
    }


     public Cursor information()

    {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor info = db.rawQuery("Select * from Registerdb",null);
        return info;
    }
}
