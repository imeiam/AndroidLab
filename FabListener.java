package gop.akiladeshwar.exercise1;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

/**
 * Created by AkilAdeshwar on 18-07-2016.
 */
public class FabListener implements View.OnClickListener {


    public static final int DEFAULT_MODE = 0;
    public static final int HELLO_ANDROID = 1;
    public static final int LOGIN_MODE = 2;
    public static final int SIGNUP_MODE = 3;

    public static int mode = DEFAULT_MODE;

    public static View rootView;
    public static Context context;
    public static Fragment fragment;


    @Override
    public void onClick(View view) {

        switch (mode) {
            case DEFAULT_MODE:
                break;
            case HELLO_ANDROID:
                Snackbar.make(view, "I respond to click events", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case LOGIN_MODE:
                if (rootView != null) {
                    TextInputEditText usernamex = (TextInputEditText) rootView.findViewById(R.id.username);
                    TextInputEditText passwordx = (TextInputEditText) rootView.findViewById(R.id.password);

                    String username = usernamex.getText().toString();
                    String password = passwordx.getText().toString();
                    if (username.matches("") || password.matches("")) {
                        Utility.printToast(context, "Invalid Entry");
                        return;
                    }
                    ListView modeList = new ListView(context);
                    final String[] stringArray = new String[]{"Boy", "Girl", "Team"};
                    final int[] resourceId = {R.drawable.student, R.drawable.girl, R.drawable.team};
                    ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(context
                            , R.layout.ex2_captcha, R.id.captcha_list_item, stringArray);
                    modeList.setAdapter(modeAdapter);

                    // Map Names to Ids For Verification
                    final HashMap<String, Integer> map = new HashMap<>();
                    for (int i = 0; i < stringArray.length; i++)
                        map.put(stringArray[i], resourceId[i]);

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Captcha Verification");
                    builder.setMessage("Who did you see in the image behind?");
                    builder.setView(modeList);

                    final AlertDialog dialog = builder.create();

                    modeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            int resourceIdOfClickedItem = map.get(stringArray[i]);
                            if (resourceIdOfClickedItem == Ex2_Login.captchaSourceId) {
                                Utility.printToast(context, "Success");
                            } else {
                                //Change Captcha on RootView
                                ((Ex2_Login) fragment).setCaptcha(rootView);
                                Utility.printToast(context, "Invalid Entry. Try Again");
                            }
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                break;

            case SIGNUP_MODE:
                if (rootView != null) {
                    TextInputEditText usernamex = (TextInputEditText) rootView.findViewById(R.id.username);
                    TextInputEditText passwordx = (TextInputEditText) rootView.findViewById(R.id.password);

                    String username = usernamex.getText().toString();
                    String password = passwordx.getText().toString();
                    if (username.matches("") || password.matches("")) {
                        Utility.printToast(context, "Invalid Entry");
                        return;
                    }
                    ((Ex2_Login.Ex2_LoginComm) fragment.getActivity()).showWelcomePage();
                }
                break;
        }
    }
}
