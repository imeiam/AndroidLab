package gop.akiladeshwar.exercise1;

/**
 * Created by AkilAdeshwar on 18-07-2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Ex2_Welcome extends Fragment {


    ImageView captchaImage;
    public static int captchaSourceId;

    int no_of_images=3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ex2_welcome,container,false);

        //Set Captcha
        captchaImage = (ImageView) rootView.findViewById(R.id.captcha);
        int random = (int)(Math.random()*1000);
        Log.d("Log Value",""+random);

        switch(random%no_of_images){
            case 0:
                captchaSourceId = R.drawable.student;
                break;
            case 1:
                captchaSourceId = R.drawable.girl;
                break;
            case 2:
                captchaSourceId = R.drawable.team;
                break;
        }
        captchaImage.setImageResource(captchaSourceId);

        //Toolbar setup
        ActivityComm activityComm = (ActivityComm) getActivity();
        activityComm.setToolbarTitle("Welcome");
        activityComm.setFabConfig(true,FabListener.SIGNUP_MODE,
                android.R.drawable.ic_input_add,rootView,getContext(),this);



        return rootView;
    }
}