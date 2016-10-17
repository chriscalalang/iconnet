package ph.edu.bulsu.compnetworkingapp.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.database.tables.TutorialsTable;
import ph.edu.bulsu.compnetworkingapp.models.Tutorial;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public class TutorialsDAO extends BaseDAO<Tutorial> {
    private static TutorialsDAO tutorialsDAO;

    public static synchronized TutorialsDAO getInstance() {
        if (tutorialsDAO == null)
            tutorialsDAO = new TutorialsDAO();
        return tutorialsDAO;
    }


    public List<Tutorial> getAll(@Nullable List<String> tags, @Nullable List<String> wordQueries) {
        List<Tutorial> tutorials = new ArrayList<>();

        int tagsCount = tags != null ? tags.size() : 0;
        int wordQueriesCount = wordQueries != null ? wordQueries.size() : 0;

        String selection = "";
        List<String> selectionArgs = new ArrayList<>();

        if (tagsCount > 0) {
            selection += "(";
            for (int i = 0; i < tagsCount; i++) {
                if (i > 0) selection += " OR ";
                selection += ("(" + TutorialsTable.TAGS + " LIKE ? )");
                selectionArgs.add("%" + tags.get(i) + "%");
            }
            selection += ")";
        }

        if (wordQueriesCount > 0) {
            if (!selection.isEmpty()) selection += " AND ";
            selection += "(";
            for (int i = 0; i < wordQueriesCount; i++) {
                if (i > 0) selection += " OR ";
                selection += ("(" + TutorialsTable.TEXT + " LIKE ? )");
                selectionArgs.add("%" + wordQueries.get(i) + "%");
            }
            selection += ")";
        }


        if (!selection.isEmpty()) {
            tutorials = getAll(selection, selectionArgs.toArray(new String[0]));
        } else {
            tutorials = getAll();
        }

        return tutorials;
    }

    @Override
    protected ContentValues getContentValues(Tutorial object) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TutorialsTable.TITLE, object.getTitle());
        contentValues.put(TutorialsTable.TEXT, object.getText());
        contentValues.put(TutorialsTable.IMAGES, new JSONArray(object.getImages()).toString());
        contentValues.put(TutorialsTable.TAGS, new JSONArray(object.getTags()).toString());
        contentValues.put(TutorialsTable.HTML, object.getHtml());

        return contentValues;
    }

    @Override
    protected String getTableName() {
        return TutorialsTable.TABLE_NAME;
    }

    @Override
    protected Tutorial getObjectFromCursor(Cursor cursor) {
        try {
            Tutorial tutorial = new Tutorial(cursor.getString(cursor.getColumnIndex(TutorialsTable.TITLE)), cursor.getString(cursor.getColumnIndex(TutorialsTable.TEXT)));

            JSONArray imagesJsonArray = new JSONArray(cursor.getString(cursor.getColumnIndex(TutorialsTable.IMAGES)));
            List<String> images = new ArrayList<>();
            for (int i = 0; i < imagesJsonArray.length(); i++)
                images.add(imagesJsonArray.get(i).toString());

            tutorial.setImages(images);


            JSONArray tagsJsonArray = new JSONArray(cursor.getString(cursor.getColumnIndex(TutorialsTable.TAGS)));
            List<String> tags = new ArrayList<>();
            for (int i = 0; i < tagsJsonArray.length(); i++)
                tags.add(tagsJsonArray.get(i).toString());

            tutorial.setTags(tags);

            tutorial.setHtml(cursor.getString(cursor.getColumnIndex(TutorialsTable.HTML)));

            return tutorial;
        } catch (JSONException e) {
            throw new RuntimeException("App error contact developer immediately");
        }
    }
}
