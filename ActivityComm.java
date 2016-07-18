package gop.akiladeshwar.exercise1;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by AkilAdeshwar on 18-07-2016.
 */
public interface ActivityComm {
    void setToolbarTitle(String title);
    void setFabConfig(boolean visibility, int mode, int source, View parent, Context context, Fragment fragment);
}
