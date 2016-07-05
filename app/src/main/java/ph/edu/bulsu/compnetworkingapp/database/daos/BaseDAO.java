package ph.edu.bulsu.compnetworkingapp.database.daos;

import android.content.ContentValues;
import android.database.Cursor;

import ph.edu.bulsu.compnetworkingapp.managers.DatabaseManager;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public abstract class BaseDAO<T> {

    protected void save(T object) {
        DatabaseManager.getInstance().insert(getTableName(), null, getContentValues(object));
    }

    protected T get(String selection, String[] selectionArgs) {
        T object = null;

        Cursor cursor = DatabaseManager.getInstance().query(getTableName(), null, selection, selectionArgs, null, null, null);
        if (cursor.moveToNext()) {
            object = getObjectFromCursor(cursor);
        }
        cursor.close();

        return object;
    }

    protected abstract ContentValues getContentValues(T object);

    protected abstract String getTableName();

    protected abstract T getObjectFromCursor(Cursor cursor);
}
