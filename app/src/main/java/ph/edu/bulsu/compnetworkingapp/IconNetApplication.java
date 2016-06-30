package ph.edu.bulsu.compnetworkingapp;

import android.app.Application;


public class IconNetApplication extends Application {

    private static final String TAG = IconNetApplication.class.getSimpleName();

    private static IconNetApplication iconNetApplication;

    public static synchronized IconNetApplication getInstance() {
        return iconNetApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        iconNetApplication = this;
    }

}
