package info.androidhive.listviewfeed.Database;

/**
 * Created by Umme on 08-Jan-17.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Umme on 07-Jan-17.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static  final int DATABASE_VERSION= 2;
   public static final String TAG = DatabaseHelper.class.getSimpleName();
   // public static final String DB_NAME = "myapp.db";
    //public static final int DB_VERSION = 1;


    //SOCIETY
    public static final String DATABASE_NAME = "Society.db";

    //User
    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";

    public static final String TABLE_NAME = "society_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "S_NAME";
    public static final String COL_3 = "S_ADDRESS";
    public static final String COL_4 = "S_BLOCK NO";
    public static final String COL_5 = "S_BUILDER NAME";
    public static final String COL_6 = "S_PINCODE";
    //OWNER/USER
    public static final String TABLE_NAME1 = "user_table";
    public static final String TB1_COL_1 = "ID";
    public static final String TB1_COL_2 = "UNAME";
    public static final String TB1_COL_3 = "NAME";
    public static final String TB1_COL_4 = "FLAT_NO";
    public static final String TB1_COL_5 = "EMAIL";
    public static final String TB1_COL_6 = "CONTACT_NO";
    public static final String TB1_COL_7 = "SOCIETY_ID";

    //SERVICES
    public static final String TABLE_NAME2 = "service_table";
    public static final String TB2_COL_1 = "ID";
    public static final String TB2_COL_2 = "SERVICE_PERSON";
    public static final String TB2_COL_3 = "DOS";   //DATE_OF_SERVICE
    public static final String TB2_COL_4 = "SERVICE_TYPE";
    public static final String TB2_COL_5 = "USER_ID";

    //SERVICE_FORCE DETAILS
    public static final String TABLE_NAME3 = "service_force_table";
    public static final String TB3_COL_1 = "ID";
    public static final String TB3_COL_2 = "SP_NAME";
    public static final String TB3_COL_3 = "SP_CONATCT_NO";   //DATE_OF_SERVICE
    public static final String TB3_COL_4 = "SP_ADDR";

    //EVENTS
    public static final String TABLE_NAME4 = "event_table";
    public static final String TB4_COL_1 = "ID";
    public static final String TB4_COL_2 = "E_NAME";
    public static final String TB4_COL_3 = "E_TYPE";
    public static final String TB4_COL_4 = "E_DATE";
    public static final String TB4_COL_5 = "DURATION";
    public static final String TB4_COL_6 = "E_VENUE";
    public static final String TB4_COL_7 = "ORGANISER_CONTACT";
    public static final String TB4_COL_8 = "USER_ID";


    //Venue
    public static final String TABLE_NAME5 = "venue_table";
    public static final String TB5_COL_1 = "V_NAME";
    public static final String TB5_COL_2 = "V_DETAILS";
    public static final String TB5_COL_3 = "V_AVAILABILITY";
    public static final String TB5_COL_4 = "V_COST";
    public static final String TB5_COL_5 = "V_CAPACITY";


    //Buy/Sell
    public static final String TABLE_NAME6 = "buy_table";
    public static final String TB6_COL_1 = "B_ID";
    public static final String TB6_COL_2 = "ITEM_NAME";
    public static final String TB6_COL_3 = "ITEM_TYPE";
    public static final String TB6_COL_4 = "DESCRIPTION";
    public static final String TB6_COL_5 = "TIMESTAMP";
    public static final String TB6_COL_6 = "CONTACT_NO.";
    public static final String TB6_COL_7 = "PRICE";
    public static final String TB6_COL_8 = "USER_ID";
    public static final String TB6_COL_9 = "SOCIETY_ID";


    //Complaint/Query
    public static final String TABLE_NAME7 = "complaint_table";
    public static final String TB7_COL_1 = "C_ID";
    public static final String TB7_COL_2 = "TYPE";
    public static final String TB7_COL_3 = "DESCRIPTION";
    public static final String TB7_COL_4 = "TIMESTAMP";
    public static final String TB7_COL_5 = "PRIORITY";
    public static final String TB7_COL_6 = "IMPACT";
    public static final String TB7_COL_7 = "USER_ID";
    public static final String TB7_COL_8 = "SOCIETY_ID";


    //Payment
    public static final String TABLE_NAME8 = "payment_table";
    public static final String TB8_COL_1 = "INVOICE";
    public static final String TB8_COL_2 = "MODE_PAY";
    public static final String TB8_COL_3 = "CHARGES";
    public static final String TB8_COL_4 = "TIMESTAMP";
    public static final String TB8_COL_5 = "USER_ID";
    public static final String TB8_COL_6 = "SOCIETY_ID";


    //Feedback
    public static final String TABLE_NAME9 = "feedback_table";
    public static final String TB9_COL_1 = "ID";
    public static final String TB9_COL_2 = "SUBJECT";
    public static final String TB9_COL_3 = "DESCRIPTION";
    public static final String TB9_COL_4 = "TIMESTAMP";
    public static final String TB9_COL_5 = "USER_ID";
    public static final String TB9_COL_6 = "SOCIETY_ID";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
      //  SQLiteDatabase db = this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,S_NAME TEXT,S_ADDRESS TEXT,S_BLOCK NO INTEGER,S_BUILDER NAME TEXT,S_PINCODE INTEGER)");
        db.execSQL("create table " + TABLE_NAME1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,NAME TEXT,FLAT_NO VARCHAR,EMAIL  VARCHAR,CONTACT_NO INTEGER,SOCIETY_ID INTEGER)");
        db.execSQL("create table " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,SERVICE_PERSON TEXT,DOS INTEGER,SERVICE_TYPE TEXT,USER_ID  INTEGER)");
        db.execSQL("create table " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,SP_NAME TEXT,SP_CONTACT_NO INTEGER,SP_ADDR  INTEGER)");
        db.execSQL("create table " + TABLE_NAME4 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,E_NAME TEXT,E_TYPE TEXT,E_DATE INTEGER,DURATION  INTEGER,E_VENUE TEXT,ORGANISER_CONTACT INTEGER,USER_ID INTEGER)");
        db.execSQL("create table " + TABLE_NAME5 + " (V_NAME TEXT,V_DETAILS TEXT,V_AVAILABILITY INTEGER,V_COST INTEGER,V_CAPACITY INTEGER)");
        db.execSQL("create table " + TABLE_NAME6 + " (B_ID INTEGER,ITEM_NAME TEXT,ITEM_TYPE TEXT,DESCRIPTION TEXT,TIMESTAMP INTEGER,CONTACT_NO INTEGER,PRICE INTEGER,USER_ID INTEGER,SOCIETY_ID INTEGER)");
        db.execSQL("create table " + TABLE_NAME7 + " (C_ID INTEGER,TYPE TEXT,DESCRIPTION TEXT,TIMESTAMP INTEGER,PRIORITY TEXT,USER_ID INTEGER,SOCIETY_ID INTEGER)");
        db.execSQL("create table " + TABLE_NAME8 + " (INVOICE INTEGER,MODE_PAY TEXT,CHARGES INTEGER,TIMESTAMP INTEGER,USER_ID INTEGER,SOCIETY_ID INTEGER)");
        db.execSQL("create table " + TABLE_NAME9 + " (ID INTEGER,SUBJECT TEXT,DESCRIPTION TEXT,TIMESTAMP INTEGER,USER_ID INTEGER,SOCIETY_ID INTEGER)");
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME7);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME8);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME9);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);

    }
    /*public boolean insertData(String uname,String name,String flat ,String email,String contact){
     SQLiteDatabase db = this.getWritableDatabase();
     ContentValues contentValues = new ContentValues();
     contentValues.put(TB1_COL_2,uname);
     contentValues.put(TB1_COL_3,name);
     contentValues.put(TB1_COL_4,flat);
     contentValues.put(TB1_COL_5,email );
     contentValues.put(TB1_COL_6,contact);

     long result = db.insert(TABLE_NAME1,null ,contentValues);
     if(result == -1)
     return false;
     else
     return true;
     }*/

    public void addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }
    public boolean getUser(String email, String pass){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_EMAIL + " = " + "'"+email+"'" + " and " + COLUMN_PASS + " = " + "'"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }

}



