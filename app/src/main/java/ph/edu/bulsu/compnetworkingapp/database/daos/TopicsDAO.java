package ph.edu.bulsu.compnetworkingapp.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.database.tables.TopicsTable;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public class TopicsDAO extends BaseDAO<Topic> {
    private static TopicsDAO topicsDAO;

    public static synchronized TopicsDAO getInstance() {
        if (topicsDAO == null)
            topicsDAO = new TopicsDAO();
        return topicsDAO;
    }


    public List<Topic> getAll(@Nullable List<String> tags, @Nullable List<String> wordQueries) {
        List<Topic> topics = new ArrayList<>();

        int tagsCount = tags != null ? tags.size() : 0;
        int wordQueriesCount = wordQueries != null ? wordQueries.size() : 0;

        String selection = "";
        List<String> selectionArgs = new ArrayList<>();

        if (tagsCount > 0) {
            selection += "(";
            for (int i = 0; i < tagsCount; i++) {
                if (i > 0) selection += " OR ";
                selection += ("(" + TopicsTable.TAGS + " LIKE ? )");
                selectionArgs.add("%" + tags.get(i) + "%");
            }
            selection += ")";
        }

        if (wordQueriesCount > 0) {
            if (!selection.isEmpty()) selection += " AND ";
            selection += "(";
            for (int i = 0; i < wordQueriesCount; i++) {
                if (i > 0) selection += " OR ";
                selection += ("(" + TopicsTable.TEXT + " LIKE ? )");
                selectionArgs.add("%" + wordQueries.get(i) + "%");
            }
            selection += ")";
        }


        if (!selection.isEmpty()) {
            topics = getAll(selection, selectionArgs.toArray(new String[0]));
        } else {
            topics = getAll();
        }

        return topics;
    }

    @Override
    protected ContentValues getContentValues(Topic object) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TopicsTable.TITLE, object.getTitle());
        contentValues.put(TopicsTable.TEXT, object.getText());
        contentValues.put(TopicsTable.IMAGES, new JSONArray(object.getImages()).toString());
        contentValues.put(TopicsTable.TAGS, new JSONArray(object.getTags()).toString());
        contentValues.put(TopicsTable.HTML, object.getHtml());

        return contentValues;
    }

    @Override
    protected String getTableName() {
        return TopicsTable.TABLE_NAME;
    }

    @Override
    protected Topic getObjectFromCursor(Cursor cursor) {
        try {
            Topic topic = new Topic(cursor.getString(cursor.getColumnIndex(TopicsTable.TITLE)), cursor.getString(cursor.getColumnIndex(TopicsTable.TEXT)));

            JSONArray imagesJsonArray = new JSONArray(cursor.getString(cursor.getColumnIndex(TopicsTable.IMAGES)));
            List<String> images = new ArrayList<>();
            for (int i = 0; i < imagesJsonArray.length(); i++)
                images.add(imagesJsonArray.get(i).toString());

            topic.setImages(images);


            JSONArray tagsJsonArray = new JSONArray(cursor.getString(cursor.getColumnIndex(TopicsTable.TAGS)));
            List<String> tags = new ArrayList<>();
            for (int i = 0; i < tagsJsonArray.length(); i++)
                tags.add(tagsJsonArray.get(i).toString());

            topic.setTags(tags);

            topic.setHtml(cursor.getString(cursor.getColumnIndex(TopicsTable.HTML)));

            return topic;
        } catch (JSONException e) {
            throw new RuntimeException("App error contact developer immediately");
        }
    }
}
