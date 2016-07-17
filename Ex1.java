package gop.akiladeshwar.exercise1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AkilAdeshwar on 17-07-2016.
 */
public class Ex1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.ex_1_content,container,false);

        //Toolbar setup
        Ex1Comm activityComm = (Ex1Comm) getActivity();
        activityComm.setToolbarTitle("Hello Android");

        return rootView;
    }

    public interface Ex1Comm{
        void setToolbarTitle(String title);
    }
}
