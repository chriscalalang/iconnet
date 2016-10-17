package ph.edu.bulsu.compnetworkingapp.managers;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.BuildConfig;
import ph.edu.bulsu.compnetworkingapp.IconNetApplication;
import ph.edu.bulsu.compnetworkingapp.database.daos.TroubleshootersDAO;
import ph.edu.bulsu.compnetworkingapp.database.daos.TutorialsDAO;
import ph.edu.bulsu.compnetworkingapp.interfaces.ResourceUpdateStatusListener;
import ph.edu.bulsu.compnetworkingapp.models.Troubleshooter;
import ph.edu.bulsu.compnetworkingapp.models.Tutorial;

/**
 * Created by Sheychan on 7/1/2016.
 */
public class ResourcesManager {

    private static ResourcesManager manager;

    private static final String ASSETS_VERSION = "assets_version";
    private static final String ASSETS_TOPIC_COUNT = "assets_topic_count";
    private static final String TOPICS_FOLDER = "topics";
    private static final String TROUBLESHOOTERS_FOLDER = "troubleshooters";
    private static final String CONTENT_TAGS_FILE_NAME = "tags.txt";
    private static final String CONTENT_TEXT_FILE_NAME = "content.txt";
    private static final String CONTENT_HTML_FILE_NAME = "content.html";

    public static boolean hasNewTopicAssets() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        return (preferences.getInt(ASSETS_VERSION, 0) != BuildConfig.VERSION_CODE) || (preferences.getInt(ASSETS_TOPIC_COUNT, 0) != getAssetsCount());
    }

    public static void updateTroubleShootingAssets() {
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Troubleshooter> troubleshooters = new ArrayList<>();


                String[] folders = new String[0];
                try {
                    folders = IconNetApplication.getInstance().getResources().getAssets().list(TROUBLESHOOTERS_FOLDER);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                for (String folder : folders) {
                    Troubleshooter troubleshooter = new Troubleshooter(folder);

                    //attempt read tags
                    try {
                        troubleshooter.setTags(Arrays.asList(readStringFromAssetFile(TROUBLESHOOTERS_FOLDER + "/" + folder + "/" + CONTENT_TAGS_FILE_NAME).split("\\W+")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    //attempt get solutions
                    List<String> solutions = new ArrayList<String>();
                    String[] solutionFileNames = new String[0];
                    try {
                        solutionFileNames = IconNetApplication.getInstance().getResources().getAssets().list(TROUBLESHOOTERS_FOLDER + "/" + folder);

                        for (String fileName : solutionFileNames) {
                            if (fileName.contains(".tbs")) {
                                solutions.add(readStringFromAssetFile(readStringFromAssetFile(TROUBLESHOOTERS_FOLDER + "/" + folder + "/" + fileName)));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    troubleshooter.setSolutions(solutions);

                    troubleshooters.add(troubleshooter);
                }

                TroubleshootersDAO.getInstance().clearStorage();
                TroubleshootersDAO.getInstance().saveAll(troubleshooters);
            }
        });
    }

    public static void updateTutorialAssets(final ResourceUpdateStatusListener listener) {
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Tutorial> tutorials = new ArrayList<>();


                String[] folders = new String[0];
                try {
                    folders = IconNetApplication.getInstance().getResources().getAssets().list(TOPICS_FOLDER);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                for (String folder : folders) {
                    Tutorial tutorial = new Tutorial(folder);

                    //attempt read text
                    try {
                        tutorial.setText(readStringFromAssetFile(TOPICS_FOLDER + "/" + folder + "/" + CONTENT_TEXT_FILE_NAME));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //attempt read html
                    try {
                        tutorial.setHtml(readStringFromAssetFile(TOPICS_FOLDER + "/" + folder + "/" + CONTENT_HTML_FILE_NAME));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //attempt read tags
                    try {
                        tutorial.setTags(Arrays.asList(readStringFromAssetFile(TOPICS_FOLDER + "/" + folder + "/" + CONTENT_TAGS_FILE_NAME).split("\\W+")));
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

                    tutorial.setImages(imageList);

                    tutorials.add(tutorial);
                }

                TutorialsDAO.getInstance().clearStorage();
                TutorialsDAO.getInstance().saveAll(tutorials);

                listener.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        preferences.edit().putInt(ASSETS_VERSION, BuildConfig.VERSION_CODE).apply();
                        preferences.edit().putInt(ASSETS_TOPIC_COUNT, getAssetsCount()).apply();

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

    public static int getAssetsCount() {
        try {
            return IconNetApplication.getInstance().getResources().getAssets().list(TOPICS_FOLDER).length + IconNetApplication.getInstance().getResources().getAssets().list(TROUBLESHOOTERS_FOLDER).length;
        } catch (IOException e) {
            return -1;
        }
    }
}
