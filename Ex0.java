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
public class Ex0 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ex_0,container,false);
        TextView textView = (TextView) rootView.findViewById(R.id.main_desc);
        textView.setTypeface(StartActivity.thinTypeface);
        return rootView;
    }
}
