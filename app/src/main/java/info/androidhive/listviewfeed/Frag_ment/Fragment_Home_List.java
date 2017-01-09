package info.androidhive.listviewfeed.Frag_ment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;


public class Fragment_Home_List extends Fragment {
   public LinearLayout l_aboutus,l_buyandsell,l_events,l_found,l_notice,l_complaints;

    public Fragment_Home_List() {
        // Required empty public constructor
    }


    public static Fragment_Home_List newInstance(String param1, String param2) {
        Fragment_Home_List fragment = new Fragment_Home_List();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment__home__list, container, false);
        l_aboutus =(LinearLayout)rootView.findViewById(R.id.about);
        l_buyandsell =(LinearLayout)rootView.findViewById(R.id.buyandsell);
        l_complaints =(LinearLayout)rootView.findViewById(R.id.complaints);
        l_found =(LinearLayout)rootView.findViewById(R.id.foundandloss);
        l_events =(LinearLayout)rootView.findViewById(R.id.events);
        Home.title.setText("Dashboard");


        l_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_About_us mAboutFragment = new Fragment_About_us();
                fragmentTransaction.add(R.id.Container, mAboutFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("about");
                Home.title.setText("About");
            }
        });

        l_buyandsell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_BuyandSell mAboutFragment = new Fragment_BuyandSell();
                fragmentTransaction.add(R.id.Container, mAboutFragment);
                //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Home.title.setText("Buy And Sell");
            }
        });
        l_complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

               Fragment_Complaints mAboutFragment = new Fragment_Complaints();
                fragmentTransaction.replace(R.id.Container, mAboutFragment);
               // fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Home.title.setText("Complaints");
            }
        });
        l_found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_Found_and_Loss mAboutFragment = new Fragment_Found_and_Loss();
                fragmentTransaction.replace(R.id.Container, mAboutFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Home.title.setText("Service Board");
            }
        }); l_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_MyEvents mAboutFragment = new Fragment_MyEvents();
                fragmentTransaction.add(R.id.Container, mAboutFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Home.title.setText("Events");
            }
        });




        return rootView;






    }




}
