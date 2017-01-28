package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;
import info.androidhive.listviewfeed.fragment.Fragment_AddEvent;

import static android.R.attr.button;


public class Fragment_SellandBuy extends Fragment {
    String[] items = {"Books","Furniture","Flat","Vehicles","Machinery","Equipments"};



    public Fragment_SellandBuy() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragmet__sell, container, false);
        Spinner sp = (Spinner) rootView.findViewById(R.id.sp);
        ArrayAdapter<String> ab = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        sp.setAdapter(ab);
        return rootView;

    }
}
