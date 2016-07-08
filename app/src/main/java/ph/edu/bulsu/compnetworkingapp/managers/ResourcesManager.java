package ph.edu.bulsu.compnetworkingapp.managers;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.BuildConfig;
import ph.edu.bulsu.compnetworkingapp.IconNetApplication;
import ph.edu.bulsu.compnetworkingapp.database.daos.TopicsDAO;
import ph.edu.bulsu.compnetworkingapp.interfaces.ResourceUpdateStatusListener;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

/**
 * Created by Sheychan on 7/1/2016.
 */
public class ResourcesManager {

    private static ResourcesManager manager;

    private static final String ASSETS_VERSION = "assets_version";
    private static final String ASSETS_TOPIC_COUNT = "assets_topic_count";
    private static final String TOPICS_FOLDER = "topics";
    private static final String CONTENT_TEXT_FILE_NAME = "content.txt";
    private static final String CONTENT_HTML_FILE_NAME = "content.html";

    public static boolean hasNewTopicAssets() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        return (preferences.getInt(ASSETS_VERSION, 0) != BuildConfig.VERSION_CODE) && (preferences.getInt(ASSETS_TOPIC_COUNT, 0) != getTopicAssetsCount());
    }

    public static void updateTopicAssets(final ResourceUpdateStatusListener listener) {
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Topic> topics = new ArrayList<>();


                String[] folders = new String[0];
                try {
                    folders = IconNetApplication.getInstance().getResources().getAssets().list(TOPICS_FOLDER);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                for (String folder : folders) {
                    Topic topic = new Topic(folder);

                    //attempt read text
                    try {
                        topic.setText(readStringFromAssetFile(TOPICS_FOLDER + "/" + folder + "/" + CONTENT_TEXT_FILE_NAME));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //attempt read html
                    try {
                        topic.setHtml(readStringFromAssetFile(TOPICS_FOLDER + "/" + folder + "/" + CONTENT_HTML_FILE_NAME));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //attempt get images
                    List<String> imageList = new ArrayList<String>();
                    String[] imageFileNames = new String[0];
                    try {
                        imageFileNames = IconNetApplication.getInstance().getResources().getAssets().list(TOPICS_FOLDER + "/" + folder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    for (String fileName : imageFileNames) {
                        if (fileName.contains(".png") || fileName.contains(".jpg")) {
                            imageList.add(fileName);
                        }
                    }

                    topic.setImages(imageList);

                    topics.add(topic);
                }

                TopicsDAO.getInstance().clearStorage();
                TopicsDAO.getInstance().saveAll(topics);

                listener.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        preferences.edit().putInt(ASSETS_VERSION, BuildConfig.VERSION_CODE).apply();
                        preferences.edit().putInt(ASSETS_TOPIC_COUNT, getTopicAssetsCount()).apply();

                        listener.onUpdateCompleted();
                    }
                });
            }
        });
    }

    private static String readStringFromAssetFile(String filepath) throws IOException {
        InputStream is = IconNetApplication.getInstance().getResources().getAssets().open(filepath);
        StringBuilder fileContent = new StringBuilder("");
        byte[] buffer = new byte[1024];

        int n;
        while ((n = is.read(buffer)) != -1) {
            fileContent.append(new String(buffer, 0, n));
        }
        return fileContent.toString();
    }

    public static int getTopicAssetsCount() {
        try {
            return IconNetApplication.getInstance().getResources().getAssets().list(TOPICS_FOLDER).length;
        } catch (IOException e) {
            return -1;
        }
    }
}
