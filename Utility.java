package gop.akiladeshwar.exercise1;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by AkilAdeshwar on 18-07-2016.
 */
public class Utility {

    public static void printToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
