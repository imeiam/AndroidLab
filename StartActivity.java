package gop.akiladeshwar.exercise1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



// Instructions
// 1.  Add Tag for fragments
// 2.  Fragments communicate only through interfaces


public class StartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
    , ActivityComm
    , Ex2_Login.Ex2_LoginComm

{


    public static Typeface title;
    public static Typeface thinTypeface;

    TextView toolbarTitle;
    Toolbar toolbar;
    NavigationView navigationView;

    FloatingActionButton fab;
    public static FabListener fabListener;

    public static String EX_0_FRAGMENT = "ex_0";
    public static String EX_1_FRAGMENT = "ex_1";
    public static String EX_2_LOGIN_FRAGMENT = "ex_2_login";
    public static String EX_2_SIGNUP_FRAGMENT = "ex_2_signup";
    public static String EX_2_WELCOME_FRAGMENT = "ex_2_welcome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,new Ex0(),EX_0_FRAGMENT)
                    .commit();
        }
        setContentView(R.layout.activity_start);

        //Setup ToolBar

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        title = Typeface.createFromAsset(getAssets(),"dead.ttf");

        thinTypeface = Typeface.createFromAsset(getAssets(),"thin.ttf");

        toolbarTitle = (TextView) findViewById(R.id.title_text);
        toolbarTitle.setTypeface(title);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView sideNavTitle  = (TextView) navigationView.getHeaderView(0).findViewById(R.id.side_nav_title);
        sideNavTitle.setTypeface(title);


        fabListener = new FabListener();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(fabListener);
        setFabConfig(false,FabListener.DEFAULT_MODE,0,null,null,null);
        navigationView.getMenu().getItem(0).setChecked(true);
        Log.d("LOG","Called");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ex_0) {
            if(toolbarTitle!=null){
                toolbarTitle.setText("Welcome to Android");
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,new Ex0(),EX_0_FRAGMENT)
                    .commit();
            setFabConfig(false,FabListener.DEFAULT_MODE,0,null,null,null);
        }
        if (id == R.id.ex_1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,new Ex1(),EX_1_FRAGMENT)
                    .commit();
        }
        if (id == R.id.ex_1_c) {
            Intent intent = new Intent(this, LifeCycle.class);
            startActivityForResult(intent,90);
        }

        if( id == R.id.ex_2_a){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,new Ex2_Login(),EX_2_LOGIN_FRAGMENT)
                    .commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setToolbarTitle(String title){
        if(toolbarTitle!=null && title!=null){
            toolbarTitle.setText(title);
        }
    }

    @Override
    public void setFabConfig(boolean visible, int mode, int source, View parent, Context context, Fragment fragment) {
        if(fab!=null){
            if(visible)
                fab.setVisibility(View.VISIBLE);
            else
                fab.setVisibility(View.INVISIBLE);
            FabListener.mode = mode;
            fab.setImageResource(source);
            fabListener.rootView = parent;
            fabListener.context = context;
            fabListener.fragment = fragment;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch(requestCode){
            case 90:
                //Select Home Again.
                navigationView.getMenu().getItem(0).setChecked(true);
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container,new Ex0(),EX_0_FRAGMENT)
//                        .commit();
                break;
        }
    }

    @Override
    public void startSignUp() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new Ex2_SignUp(),EX_2_SIGNUP_FRAGMENT)
                .commit();
    }

    @Override
    public void showWelcomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new Ex2_Welcome(),EX_2_WELCOME_FRAGMENT)
                .commit();
    }
}
