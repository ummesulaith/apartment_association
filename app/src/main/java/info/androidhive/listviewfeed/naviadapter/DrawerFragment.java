package info.androidhive.listviewfeed.naviadapter;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import info.androidhive.listviewfeed.Frag_ment.Fragment_Home_List;
import info.androidhive.listviewfeed.Frag_ment.My_services;
import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;


import info.androidhive.listviewfeed.fragment.Fragment_Events;
import info.androidhive.listviewfeed.fragment.Fragment_MyNotifications;
import info.androidhive.listviewfeed.fragment.Fragment_Profile;
import info.androidhive.listviewfeed.fragment.Fragment_Socity;

import static info.androidhive.listviewfeed.R.id.textView8;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment implements View.OnClickListener {

    static DrawerLayout drawerLayout;
    public TextView textView, textView1, textView2, textView3, textView4, textView5, textView6,textView8,textView55;
    ViewPager viewPager;
    private TextView txtLogout;


    public static DrawerFragment newInstance(DrawerLayout drawer) {
        // Required empty public constructor
        drawerLayout = drawer;
        DrawerFragment f = new DrawerFragment();
        return f;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.drawyer_laout_items, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        initialise(view);
        Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);


        view.findViewById(R.id.textView2).startAnimation(animation1);
        view.findViewById(R.id.textView3).startAnimation(animation1);
        view.findViewById(R.id.textView4).startAnimation(animation1);
        view.findViewById(R.id.textView5).startAnimation(animation1);
        view.findViewById(R.id.textView6).startAnimation(animation1);
        view.findViewById(R.id.textView7).startAnimation(animation1);
        view.findViewById(R.id.textView8).startAnimation(animation1);









    }

    private void callback(View view, int position) {
        Intent intent;
        drawerLayout.closeDrawer(Gravity.LEFT);

    }

    private void initialise(View view) {
//        view.findViewById(R.id.textView).setOnClickListener(this);


        textView = (TextView) view.findViewById(R.id.textView2);
        textView1 = (TextView) view.findViewById(R.id.textView3);
        textView2 = (TextView) view.findViewById(R.id.textView4);
        textView3 = (TextView) view.findViewById(R.id.textView5);
        textView4 = (TextView) view.findViewById(R.id.textView6);
        textView5 = (TextView) view.findViewById(R.id.textView7);
        textView6 = (TextView) view.findViewById(R.id.churchname);
        textView8 = (TextView) view.findViewById(R.id.textView8);
        textView55=(TextView) view.findViewById(R.id.textView);


//            textView.setText("Fragment_Events");
//            textView1.setText("Complaints");
//            textView2.setText("Foud and Loss");
//            textView3.setText("Buy and Sell");
//            textView4.setText("Notice Board");
//            textView5.setText("About");
//            textView6.setText("Contact us");



        view.findViewById(R.id.textView2).setOnClickListener(this);
        view.findViewById(R.id.textView3).setOnClickListener(this);
        view.findViewById(R.id.textView4).setOnClickListener(this);
        view.findViewById(R.id.textView5).setOnClickListener(this);
        view.findViewById(R.id.textView6).setOnClickListener(this);
        view.findViewById(R.id.textView7).setOnClickListener(this);
        view.findViewById(R.id.textView8).setOnClickListener(this);

    }
  /* private void logout() {
       session.setLoggedin(false);
       getActivity().finish();
   }**/


    @Override
    public void onClick(View v) {

        drawerLayout.closeDrawers();
        switch (v.getId()) {

            case R.id.textView2:
//                viewPager.setCurrentItem(0);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_Home_List  mAboutFragment= new Fragment_Home_List();
                fragmentTransaction.replace(R.id.Container, mAboutFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Home.title.setText("Dashboard");

                break;
            case R.id.textView3:
//                viewPager.setCurrentItem(1);
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();

                Fragment_Profile mAboutFragment1 = new Fragment_Profile();
                fragmentTransaction1.replace(R.id.Container, mAboutFragment1);
                fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction1.addToBackStack(null);

                fragmentTransaction1.commit();

                Home.title.setText("Profile");

                break;
            case R.id.textView4:
//                viewPager.setCurrentItem(2);
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

                Fragment_Socity mAboutFragment2 = new Fragment_Socity();
                fragmentTransaction2.replace(R.id.Container, mAboutFragment2);
                fragmentTransaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();

                Home.title.setText("My Society");
                break;
            case R.id.textView5:
//                viewPager.setCurrentItem(3);
                FragmentManager fragmentManager3 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();

                Fragment_Events mAboutFragment3 = new Fragment_Events();
                fragmentTransaction3.replace(R.id.Container, mAboutFragment3);
                fragmentTransaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();

                Home.title.setText("My Events");
                break;

            case R.id.textView6:
//                viewPager.setCurrentItem(4);
                FragmentManager fragmentManager4 = getFragmentManager();
                FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();

                Fragment_MyNotifications mAboutFragment4 = new Fragment_MyNotifications();
                fragmentTransaction4.replace(R.id.Container, mAboutFragment4);
                fragmentTransaction4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction4.addToBackStack(null);
                fragmentTransaction4.commit();

                Home.title.setText("My Notifications");
                break;
            case R.id.textView7:
//                viewPager.setCurrentItem(5);
            getActivity().finish();
                break;

            case R.id.textView8:
                FragmentManager fragmentManager5 = getFragmentManager();
                FragmentTransaction fragmentTransaction5 = fragmentManager5.beginTransaction();

                My_services mAboutFragment5 = new My_services();
                fragmentTransaction5.replace(R.id.Container, mAboutFragment5);
                fragmentTransaction5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction5.addToBackStack(null);
                fragmentTransaction5.commit();

                Home.title.setText("My Services");
                break;



                }

            }

        }





