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

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_BuyandSell extends Fragment {
    public Button b1;
    ArrayAdapter<String> ab;


    public Fragment_BuyandSell() {
        // Required empty public constructor
    }

    public static Fragment_BuyandSell newInstance(String param1, String param2) {
        Fragment_BuyandSell fragment1 = new Fragment_BuyandSell();
        Bundle args = new Bundle();

        fragment1.setArguments(args);
        return fragment1;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView  =inflater.inflate(R.layout.fragment_buyandsell, container, false);
        ab = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1);
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
