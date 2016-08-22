package ph.edu.bulsu.compnetworkingapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import ph.edu.bulsu.compnetworkingapp.IconNetApplication;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class DeviceUtils {

    public static int convertDpToPx(int dp) {

        Resources r = IconNetApplication.getInstance().getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());

        return (int) px;
    }


    public static int getDeviceWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) IconNetApplication.getInstance().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);

        return metrics.widthPixels;
    }

    public static int getDeviceHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) IconNetApplication.getInstance().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);

        return metrics.heightPixels;
    }
}
