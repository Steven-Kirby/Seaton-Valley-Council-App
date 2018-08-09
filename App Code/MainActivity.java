package com.team8.seatonvalley;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by tomsturgeon on 30/03/2018.
 * Last Edited by Steven Kirby on 22/04/2018.
 *
 * MainActivity is the only activity in the app with exception to the splashscreen,
 * this holds all the fragments and does the swapping of them as well as contains the information for the menu.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, new WelcomeFragment());
        ft.addToBackStack("tag");
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override






    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar person clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Select desired screen from menu selection using switch statement
    private void displaySelectedScreen(int id)
    {
        Fragment fragment = null;

        switch(id){
            case R.id.nav_news:
                fragment = new NewsFragment();
                break;
            case R.id.nav_events:
                fragment = new EventsFragment();
                break;
            case R.id.nav_meetings:
                fragment = new MeetingsFragment();
                break;
            case R.id.nav_contact:
                fragment = new ContactFragment();
                break;
            case R.id.nav_information:
                fragment = new InformationFragment();
                break;
            case R.id.nav_maps:
                fragment = new MapFragment();
                break;
            case R.id.nav_social:
                fragment = new SocialFragment();
                break;
            case R.id.nav_complain:
                fragment = new ComplaintFragment();
                break;
        }

        if(fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.addToBackStack("tag");
            ft.commit();
        }

        // Close the nav drawer after selection is made
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view person clicks here.
        int id = item.getItemId();
        //Pass numeric id into custom made method to switch display
        displaySelectedScreen(id);
        return true;
    }


}
