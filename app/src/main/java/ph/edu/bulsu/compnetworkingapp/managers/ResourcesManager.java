package ph.edu.bulsu.compnetworkingapp.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.io.IOException;

import ph.edu.bulsu.compnetworkingapp.BuildConfig;
import ph.edu.bulsu.compnetworkingapp.IconNetApplication;

/**
 * Created by Sheychan on 7/1/2016.
 */
public class ResourcesManager {

    private static ResourcesManager manager;

    private static final String ASSETS_VERSION = "assets_version";
    private static final String ASSETS_TOPIC_COUNT = "assets_topic_count";

    public static boolean hasNewTopicAssets() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        return (preferences.getInt(ASSETS_VERSION, 0) != BuildConfig.VERSION_CODE) && (preferences.getInt(ASSETS_TOPIC_COUNT, 0) != getTopicAssetsCount());
    }

    public static void updateTopicAssets() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(IconNetApplication.getInstance());

        //TODO update asyncronously before next code

        preferences.edit().putInt(ASSETS_VERSION, BuildConfig.VERSION_CODE).apply();
        preferences.edit().putInt(ASSETS_TOPIC_COUNT, getTopicAssetsCount()).apply();
    }

    public static int getTopicAssetsCount() {
        try {
            return IconNetApplication.getInstance().getResources().getAssets().list("topics").length;
        } catch (IOException e) {
            return -1;
        }
    }
}
