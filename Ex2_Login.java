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
import android.widget.TextView;

public class Ex2_Login extends Fragment {


    ImageView captchaImage;
    public static int captchaSourceId;

    int no_of_images=3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ex_2_login,container,false);

        setCaptcha(rootView);

        //Toolbar setup
        ActivityComm activityComm = (ActivityComm) getActivity();
        activityComm.setToolbarTitle("Login");
        activityComm.setFabConfig(true,FabListener.LOGIN_MODE,
                android.R.drawable.ic_menu_send,rootView,getContext(),this);

        final Ex2_LoginComm loginComm = (Ex2_LoginComm) getActivity();
        //TextView Setup

        TextView textView = (TextView) rootView.findViewById(R.id.signup_text);
        textView.setTypeface(StartActivity.thinTypeface);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginComm.startSignUp();
            }
        });

        return rootView;
    }


    public void setCaptcha(View rootView){
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
    }

    public interface Ex2_LoginComm{
        void startSignUp();
        void showWelcomePage();
    }

}