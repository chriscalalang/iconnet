package ph.edu.bulsu.compnetworkingapp.database.daos;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.managers.DatabaseManager;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public abstract class BaseDAO<T> {

    public void save(T object) {
        DatabaseManager.getInstance().insert(getTableName(), null, getContentValues(object));
    }

    public void saveAll(List<T> objects) {
        DatabaseManager.getInstance().beginTransaction();
        for (T object : objects) {
            save(object);
        }
        DatabaseManager.getInstance().endTransaction();
    }

    public T get(String selection, String[] selectionArgs) {
        T object = null;

        Cursor cursor = DatabaseManager.getInstance().query(getTableName(), null, selection, selectionArgs, null, null, null);
        if (cursor.moveToNext()) {
            object = getObjectFromCursor(cursor);
        }
        cursor.close();

        return object;
    }

    public List<T> getAll() {
        List<T> objects = new ArrayList<>();

        Cursor cursor = DatabaseManager.getInstance().query(getTableName(), null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            objects.add(getObjectFromCursor(cursor));
        }
        cursor.close();

        return objects;
    }

    public void clearStorage() {
        DatabaseManager.getInstance().delete(getTableName(), null, null);
    }

    protected abstract ContentValues getContentValues(T object);

    protected abstract String getTableName();

    protected abstract T getObjectFromCursor(Cursor cursor);
}
