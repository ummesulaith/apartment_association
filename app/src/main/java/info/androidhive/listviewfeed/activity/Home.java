package info.androidhive.listviewfeed.activity;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.Frag_ment.Fragment_Home_List;
import info.androidhive.listviewfeed.naviadapter.Constants;
import info.androidhive.listviewfeed.naviadapter.DrawerFragment;
import info.androidhive.listviewfeed.naviadapter.ViewPagerAdapter;


public class Home extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
     public static TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        initialize1();


//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment_Home_List mAboutFragment = new Fragment_Home_List();
        fragmentTransaction.replace(R.id.Container, mAboutFragment,"home");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();


    }



    public void initialize1() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);

        title=(TextView)findViewById(R.id.title);
       String t= "The fuck work here";

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.navigation_view, new DrawerFragment().newInstance(drawerLayout), Constants.DrawerFragment)
                .commit();


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                drawerToggle.syncState();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

//                drawerToggle.syncState();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);




    }



    }









