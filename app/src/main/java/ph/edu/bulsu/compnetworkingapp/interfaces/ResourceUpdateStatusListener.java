package ph.edu.bulsu.compnetworkingapp.interfaces;

import android.os.Handler;
import android.view.View;

/**
 * Created by Sheychan on 7/6/2016.
 */
public interface ResourceUpdateStatusListener {
    View getHandler();

    void onUpdateCompleted();
}
