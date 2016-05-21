package ph.edu.bulsu.compnetworkingapp.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.fragment.Troubleshooting;

/**
 * Created by FDM CjC on 3/12/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "iconNetDb";

    private static final String TABLE_TOPICS = "topics";

    private static final String KEY_ID = "id";

    private static final String KEY_TITLE = "title";

    private static final String KEY_CONTENT = "content";

    private static final String KEY_CREATED_AT = "created_at";

    private static final String KEY_UPDATED_AT = "updated_at";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("here:", "CJ WAS HERE");
        String CREATE_TOPICS_TABLE = "CREATE TABLE " + TABLE_TOPICS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
                + KEY_CONTENT + " TEXT," + KEY_CREATED_AT + "TIMESTAMP," + KEY_UPDATED_AT + "TIMESTAMP" + ")";


        db.execSQL(CREATE_TOPICS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOPICS);

        onCreate(db);
    }

    public void onCorruption(SQLiteDatabase db)
    {
        Log.d("DB ERROR:", db.toString());
    }

    public void addTopic(Troubleshooting troubleshooting)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, troubleshooting.getTopic()); // Title
        values.put(KEY_CONTENT, troubleshooting.getContent()); // Content

// Inserting Row
        db.insert(TABLE_TOPICS, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Shops
    public List<Troubleshooting> getAllTopics() {
        List<Troubleshooting> shopList = new ArrayList<Troubleshooting>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TOPICS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Troubleshooting shop = new Troubleshooting();
                shop.setID(Integer.parseInt(cursor.getString(0)));
                shop.setTopic(cursor.getString(1));
                shop.setContent(cursor.getString(2));
// Adding contact to list
                shopList.add(shop);
            } while (cursor.moveToNext());
        }

// return contact list
        return shopList;
    }
}
