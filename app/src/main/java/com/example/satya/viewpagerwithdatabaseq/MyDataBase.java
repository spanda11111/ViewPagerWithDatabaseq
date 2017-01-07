package com.example.satya.viewpagerwithdatabaseq;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by satya on 12/28/2016.
 */
//step 2:create a dabase java file separately which act as CONTROLLER
public class MyDataBase {
    //step 5: declaire required variables
    MyHelper myHelper ;
    SQLiteDatabase sqLiteDatabase ;//for doing DML operation
    //step 6: create object for MyHelper variable by taking an constructor
    public MyDataBase(Context c)
    {
        myHelper = new MyHelper(c,"techpalle.db",null,1);

    }
    //step7 :create sqlitedatabase object by using open method
    public void open()
    {
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    //step 8: perform DML operartion
    public void insertStudent(String name, String subject,String email)
    {
        ContentValues cv= new ContentValues();
        cv.put("sname",name);
        cv.put("ssubject",subject);
        cv.put("semail",email);
        sqLiteDatabase.insert("student",null,cv);//here inserting rows

    }
    //keep update and delete() on hold
  /*  public void updateEmployee()
    {
        ContentValues cv= new ContentValues() ;
        cv.put("mgr",8);
        sqLiteDatabase.update("Employee",cv,"ename=?",new String[]{"Laxmi"},null);
    }*/
    public Cursor queryStudent()
    {
        Cursor c= null;
        //Q1: read all student details
       c = sqLiteDatabase.query("student",null,null,null,null,null,null);
        //Q2: read student with sno2
        //c =sqLiteDatabase.query("student",null,"_id",null,null,null,null);
        //Q3: read only details of student "andy"
       // c= sqLiteDatabase.query("student",null,"sname='aqib'",null,null,null,null);
        //Q4: write query for reading all details of whose name starts with  'M'
        //c= sqLiteDatabase.query("Student",null,"sname LIKE 'M%'",null,null,null,null);
//        if (c!=null)
//        {
//            while(c.moveToNext())
//            {
//                String sname= c.getString(2);
//                //Toast.makeText(, "hhhh"+sname, Toast.LENGTH_SHORT).show();
//
//            }
//        }

        //Q5:read the data whiose name ends with 'K'
        //c= sqLiteDatabase.query("student",null,"sname LIKE '%K'",null,null,null,null);



        return  c;
    }
    //step 9 : close data base
    public void close()
    {
        sqLiteDatabase.close();
    }
    //Step3: create Inner Healper class for DDL operation
    private class MyHelper extends SQLiteOpenHelper {
        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //Step 4: create all required tables in this method
            //during creating sql command you have to also give semicolon inside doublecort
            db.execSQL("create table student(_id integer primary key, sname text, ssubject text, semail text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
