package ph.edu.bulsu.compnetworkingapp.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.logging.Logger;

import ph.edu.bulsu.compnetworkingapp.IconNetApplication;
import ph.edu.bulsu.compnetworkingapp.database.tables.TopicsTable;


public class DatabaseManager extends SQLiteOpenHelper {
    private static final Logger logger = Logger.getLogger(DatabaseManager.class.getSimpleName());


    private static final String DATABASE_NAME = "db_iconnet";

    private static final int DATABASE_VERSION = 1;

    private static DatabaseManager sDatabaseManager;

    private SQLiteDatabase database;

    private Context context;

    public DatabaseManager(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        getDatabase();
    }


    public static synchronized DatabaseManager getInstance() {
        if (sDatabaseManager == null) {
            sDatabaseManager = new DatabaseManager(IconNetApplication.getInstance().getApplicationContext(),
                    DATABASE_NAME, null, DATABASE_VERSION);
        }

        return sDatabaseManager;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        logger.info("Creating database...");
        TopicsTable.onCreate(db);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        logger.info("Updating database from version " + oldVersion + " to version " + newVersion + ".");

    }


    private synchronized SQLiteDatabase getDatabase() {
        if (database == null) {
            database = getWritableDatabase();
        }

        return database;
    }

    public synchronized void beginTransaction() {
        getDatabase().beginTransaction();
    }

    public synchronized void endTransaction() {
        getDatabase().setTransactionSuccessful();
        getDatabase().endTransaction();
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        return getDatabase().insert(table, nullColumnHack, values);
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        int numRowsAffected = getDatabase().update(table, values, whereClause, whereArgs);


        return numRowsAffected;
    }

    public int delete(String table, String whereClause, String[] whereArgs) {
        int numRowsAffected = getDatabase().delete(table, whereClause, whereArgs);

        logger.info("[DELETE table = " + table + "] Number of rows affected: " + Integer.toString(numRowsAffected));

        return numRowsAffected;
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getDatabase().query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public Cursor rawQuery(String query, String[] selectionArgs) {
        return getDatabase().rawQuery(query, selectionArgs);
    }


    public String[] getTableColumnNames(String table) {
        Cursor cursor = DatabaseManager.getInstance().query(table, null, null, null, null, null, null);
        String[] columnNames = cursor.getColumnNames();

        cursor.close();

        return columnNames;
    }
}