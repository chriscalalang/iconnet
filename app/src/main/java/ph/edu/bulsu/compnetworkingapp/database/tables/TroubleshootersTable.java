package ph.edu.bulsu.compnetworkingapp.database.tables;

import android.database.sqlite.SQLiteDatabase;

import java.util.logging.Logger;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public class TroubleshootersTable {
    private static final Logger logger = Logger.getLogger(TroubleshootersTable.class.getSimpleName());

    public static final String TABLE_NAME = "tbl_troubleshooters";
    public static final String TITLE = "_title";
    public static final String SOLUTIONS = "_solutions";
    public static final String TAGS = "_tags";

    private static final String TABLE_CREATE_COMMAND = "CREATE TABLE "
            + TABLE_NAME + "('"
            + TITLE + "' TEXT PRIMARY KEY, '"
            + TAGS + "' TEXT, '"
            + SOLUTIONS + "' TEXT); ";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_COMMAND);
        logger.info(TABLE_NAME + " Table created.");
    }


    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            default:
                logger.info("Unknown version.");
                break;
        }
        logger.info(TABLE_NAME + " Table upgraded from version " + oldVersion + " to " + "version " + newVersion + ".");
    }
}
