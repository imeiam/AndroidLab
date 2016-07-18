package gop.akiladeshwar.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycle extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_life_cycle);
        TextView textView = (TextView) findViewById(R.id.display_text);
        if(StartActivity.title!=null) {
            textView.setTypeface(StartActivity.thinTypeface);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"On Start Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(this,"On Resume Called",Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Toast.makeText(this,"On Pause Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"On Stop Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"On Destroy Called",Toast.LENGTH_SHORT).show();
    }

}
