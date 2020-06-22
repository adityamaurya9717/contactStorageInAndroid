package com.example.contact_storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Arrays;

public class DBhelper extends SQLiteOpenHelper {

   public Context context;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contactdata";
    public static final String Tablename="contactlist1";

    public static final String Name="name";
    public static final String Phonenumber="phonenumber";
    public static final String Email="email";
    public static  SQLiteDatabase mydb=null;

    public DBhelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    public static final String Create_Table="Create table "+Tablename+"("+Name+" VARCHAR(255) ,"+Phonenumber+" VARCHAR(255) ,"+Email+" VARCHAR(255));";
    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
       db.execSQL(Create_Table);
            Toast.makeText(context,"Succesfully",Toast.LENGTH_LONG).show();
            this.mydb=db;
            Log.d("con","Connect sucessfully");
        }catch (Exception e){
            Log.d("err"," Error");

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    public String[] readData(SQLiteDatabase db,int column){
      Cursor cursor=db.rawQuery("select * from contactlist1",null);

        ArrayList<String> name = new ArrayList<String>();
        if(cursor.getCount()==0){Log.d("data","No Data");}
        else{
            while (cursor.moveToNext()) {

                name.add(cursor.getString(column));


            }
        }
        cursor.close();
        Object[] Array=name.toArray();
        String[] ar= Arrays.copyOf(Array,Array.length,String[].class);
        return  ar;

    }

    public String[] searchViewData(SQLiteDatabase db,String text){
        //String sql="select * from contactlist1 where name like "+text+"%";
        String sql="select * from contactlist1";

        Cursor cursor=db.rawQuery(sql,null);

        ArrayList<String> name = new ArrayList<String>();
        if(cursor.getCount()==0){Log.d("data","No Data");}
        else{
            while (cursor.moveToNext()) {

                name.add(cursor.getString(0));


            }
        }
        cursor.close();
        Object[] Array=name.toArray();
        String[] ar= Arrays.copyOf(Array,Array.length,String[].class);
        return  ar;

    }

}
