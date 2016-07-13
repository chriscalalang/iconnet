package ph.edu.bulsu.compnetworkingapp.interfaces;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.SearchView;

import java.util.List;

/**
 * Created by FDM Sydney on 7/5/2016.
 */
public interface MainViewController {

    TabLayout getTabLayout();

    List<SearchView.OnQueryTextListener> getQueryTextListeners();
}
