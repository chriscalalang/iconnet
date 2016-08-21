package ph.edu.bulsu.compnetworkingapp.utils;

import android.content.res.Resources;
import android.util.TypedValue;

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
}
