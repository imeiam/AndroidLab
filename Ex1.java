package gop.akiladeshwar.exercise1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AkilAdeshwar on 17-07-2016.
 */
public class Ex1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ex_1_content,container,false);

        TextView textView = (TextView) rootView.findViewById(R.id.hello_world);
        textView.setTypeface(StartActivity.thinTypeface);

        //Toolbar setup
        ActivityComm activityComm = (ActivityComm) getActivity();
        activityComm.setToolbarTitle("Hello Android");
        activityComm.setFabConfig(true,FabListener.HELLO_ANDROID,android.R.drawable.ic_menu_mylocation,null,null,this);
        return rootView;
    }


}
