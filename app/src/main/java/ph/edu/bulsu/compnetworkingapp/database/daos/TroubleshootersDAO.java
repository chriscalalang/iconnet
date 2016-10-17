package ph.edu.bulsu.compnetworkingapp.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.database.tables.TroubleshootersTable;
import ph.edu.bulsu.compnetworkingapp.models.Troubleshooter;
import ph.edu.bulsu.compnetworkingapp.models.Troubleshooter;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public class TroubleshootersDAO extends BaseDAO<Troubleshooter> {
    private static TroubleshootersDAO troubleshootersDAO;

    public static synchronized TroubleshootersDAO getInstance() {
        if (troubleshootersDAO == null)
            troubleshootersDAO = new TroubleshootersDAO();
        return troubleshootersDAO;
    }


    public List<Troubleshooter> getAll(@Nullable List<String> tags, @Nullable List<String> wordQueries) {
        List<Troubleshooter> troubleshooters;

        int tagsCount = tags != null ? tags.size() : 0;
        int wordQueriesCount = wordQueries != null ? wordQueries.size() : 0;

        String selection = "";
        List<String> selectionArgs = new ArrayList<>();

        if (tagsCount > 0) {
            selection += "(";
            for (int i = 0; i < tagsCount; i++) {
                if (i > 0) selection += " OR ";
                selection += ("(" + TroubleshootersTable.TAGS + " LIKE ? )");
                selectionArgs.add("%" + tags.get(i) + "%");
            }
            selection += ")";
        }

        if (wordQueriesCount > 0) {
            if (!selection.isEmpty()) selection += " AND ";
            selection += "(";
            for (int i = 0; i < wordQueriesCount; i++) {
                if (i > 0) selection += " OR ";
                selection += ("(" + TroubleshootersTable.SOLUTIONS + " LIKE ? )");
                selectionArgs.add("%" + wordQueries.get(i) + "%");
            }
            selection += ")";
        }


        if (!selection.isEmpty()) {
            troubleshooters = getAll(selection, selectionArgs.toArray(new String[0]));
        } else {
            troubleshooters = getAll();
        }

        return troubleshooters;
    }

    @Override
    protected ContentValues getContentValues(Troubleshooter object) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TroubleshootersTable.TITLE, object.getTitle());
        contentValues.put(TroubleshootersTable.SOLUTIONS, new JSONArray(object.getSolutions()).toString());
        contentValues.put(TroubleshootersTable.TAGS, new JSONArray(object.getTags()).toString());

        return contentValues;
    }

    @Override
    protected String getTableName() {
        return TroubleshootersTable.TABLE_NAME;
    }

    @Override
    protected Troubleshooter getObjectFromCursor(Cursor cursor) {
        try {
            Troubleshooter troubleshooter = new Troubleshooter(cursor.getString(cursor.getColumnIndex(TroubleshootersTable.TITLE)));

            JSONArray solutionsJsonArray = new JSONArray(cursor.getString(cursor.getColumnIndex(TroubleshootersTable.SOLUTIONS)));
            List<String> solutions = new ArrayList<>();
            for (int i = 0; i < solutionsJsonArray.length(); i++)
                solutions.add(solutionsJsonArray.get(i).toString());

            troubleshooter.setSolutions(solutions);


            JSONArray tagsJsonArray = new JSONArray(cursor.getString(cursor.getColumnIndex(TroubleshootersTable.TAGS)));
            List<String> tags = new ArrayList<>();
            for (int i = 0; i < tagsJsonArray.length(); i++)
                tags.add(tagsJsonArray.get(i).toString());

            troubleshooter.setTags(tags);

            return troubleshooter;
        } catch (JSONException e) {
            throw new RuntimeException("App error contact developer immediately");
        }
    }
}
