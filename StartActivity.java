package gop.akiladeshwar.exercise1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
    , Ex1.Ex1Comm

{


    public static Typeface title;
    public static Typeface thinTypeface;

    TextView toolbarTitle;
    Toolbar toolbar;

    FloatingActionButton fab;

    public static String EX_0_FRAGMENT = "ex_0";
    public static String EX_1_FRAGMENT = "ex_1";

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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView sideNavTitle  = (TextView) navigationView.getHeaderView(0).findViewById(R.id.side_nav_title);
        sideNavTitle.setTypeface(title);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "I respond to Click events", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setFabVisibility(false);
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
            setFabVisibility(false);
        }
        if (id == R.id.ex_1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,new Ex1(),EX_1_FRAGMENT)
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
    public void setFabVisibility(boolean visible) {
        if(fab!=null){
            if(visible)
                fab.setVisibility(View.VISIBLE);
            else
                fab.setVisibility(View.INVISIBLE);
        }
    }
}
