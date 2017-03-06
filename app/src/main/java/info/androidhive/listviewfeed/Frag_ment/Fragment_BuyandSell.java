package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_BuyandSell extends Fragment {
    public Button b1;
    ArrayAdapter<String> ab;

    public LinearLayout l_mobile_tablets,electronics,l_furnitures,l_vehicles,l_pets,l_kids;

    public Fragment_BuyandSell() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView  =inflater.inflate(R.layout.fragment_buyandsell, container, false);

        electronics=(LinearLayout) rootView.findViewById(R.id.electronics);
        l_furnitures=(LinearLayout)rootView.findViewById(R.id.furnitures);
        l_mobile_tablets=(LinearLayout) rootView.findViewById(R.id.phones);
        l_pets=(LinearLayout)rootView.findViewById(R.id.pets);
        l_vehicles=(LinearLayout)rootView.findViewById(R.id.vehicles);
        l_kids=(LinearLayout)rootView.findViewById(R.id.kids);

     ab = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1);


        electronics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here
                // this will be called whenever user click anywhere in Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                electronics_appliances_fragment f1 = new electronics_appliances_fragment();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText("Electronics and Appliances!!");

            }
        });

        l_mobile_tablets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here
                // this will be called whenever user click anywhere in Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                mobile_tablets_fragment f1 = new mobile_tablets_fragment();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText(" Mobile and Tablets !! ");

            }
        });

        l_furnitures.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here
                // this will be called whenever user click anywhere in Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                furnitures_fragment f1 = new furnitures_fragment();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText(" Furniture !! ");

            }
        });

        l_vehicles.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here
                // this will be called whenever user click anywhere in Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                vehicles_fragment f1 = new vehicles_fragment();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText(" Vehicles !! ");

            }
        });
        l_pets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here
                // this will be called whenever user click anywhere in Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                pets_fragment f1 = new pets_fragment();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText(" Pets section !! ");

            }
        });
        l_kids.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here
                // this will be called whenever user click anywhere in Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                kids_fragment f1 = new kids_fragment();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText(" kids section !! ");

            }
        });
        b1 = (Button) rootView.findViewById(R.id.btnsellandbuy);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_SellandBuy f1 = new Fragment_SellandBuy();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("BuyandSell");
                Home.title.setText(" Sell Anything Here !! ");
            }
        });

        return rootView;

    }
}
