package ph.edu.bulsu.compnetworkingapp.database.daos;

import android.content.ContentValues;
import android.database.Cursor;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
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
